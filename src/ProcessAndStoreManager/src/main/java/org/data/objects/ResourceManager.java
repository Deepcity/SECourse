package org.data.objects;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class ResourceManager {
    static ResourceManager resourceManager = new ResourceManager();
    private Map<String, Integer> resourceItems;
    private PublishSubject<Map<String, Integer>> subject;
    static int multex = 1;

    static int ULIMIT = 300;

    public static int getULIMIT() {
        return ULIMIT;
    }

    static boolean getMultex(){
        return multex == 0;
    }

    static void P() throws InterruptedException {
        while(getMultex()) sleep(100);
        modifyMultex();
    }

    static void V() {
        modifyMultex();
    }

    static void modifyMultex(){
        multex ^= 1;
    }

    public ResourceManager() {
        this.resourceItems = new HashMap<>();
        this.subject = PublishSubject.create();
    }

    public Observable<Map<String, Integer>> getObservable() {
        return subject;
    }

    public void updateResourceItems(Map<String, Integer> updatedItems) {
        resourceItems.putAll(updatedItems);
        subject.onNext(resourceItems);
    }

    // Example method to add or update a single resource item
    public void updateResourceItem(String ukey, Integer uvalue) {
        resourceItems.compute(ukey, (key,value)->{
            if (value != null) {
                return value + uvalue;  // 基于当前值更新值
            } else {
                return 0;  // 如果键不存在或值为null，则设置一个默认值
            }
        });
        subject.onNext(resourceItems);
    }

    int getResourceNumberByName(String name){
        if(!resourceItems.containsKey(name)) return 0;
        return resourceItems.get(name);
    }

    public Map<String, Integer> getResourceItems() {
        return new HashMap<>(resourceItems);
    }

    public static ResourceManager getInstance(){
        return resourceManager;
    }
}
