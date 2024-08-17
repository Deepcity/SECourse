# 三种操作系统的简单模拟

## 介绍

该项目是课程软件工程与操作系统的结业项目，包含两部分——程序源码与设计文档。

代码环境如下

| 使用IDE        | IDEA 2023.1.3        |
| -------------- | -------------------- |
| 使用开发框架   | Maven 4.0.0          |
| 使用第三方库项 | Junit 3.8.1          |
|                | jgoodies-forms 1.9.0 |
|                | Rxjava 2.2.21        |
|                | javafx-base 22       |
|                | forms_rt 7.0.1       |
| 编译环境       | Maven 13             |
| 运行环境       | Jdk 17               |

程序文档整体采用typora，word编写，部分word文件由typora编写，绘图部分采用typora mermaid，star xml 以及 visio。图片导出使用icv矢量格式，生成jar包采用mvc架构编译生成，通过exe4j、inno打包生成安装包。

## 安装方式

运行源码请在idea中直接克隆仓库并配置maven环境，然后使用生命周期插件clean后compile即可运行。在doc中存放本项目的文本文件，installer，jarpackage，application中存放了项目的安装、程序文件，值得注意的是，项目可以直接生成exe文件，但需要jre环境才能运行。

生成exe以及安装包文件所需的脚本文件均在config当中。通过exe4j以及inno分别调用脚本文件，并修改脚本文件当中的路径即可正常生成文件

若在安装过程中出现错误，请在issue区提出，我看到后会及时处理

## 软件项目名

ProcessAndStoreManager

## 作者

Deepcity

## 组织

江西理工大学

使用前请阅读使用手册[三种操作系统简单模拟-使用手册](./三种操作系统简单模拟-使用手册.md)

反馈渠道为：<http://osfeedback.keboe.cn/>，有问题请在该网站留言

一些。

## 一些程序截图

## 结果截图

主界面导航界面

![img](https://s2.loli.net/2024/08/16/qXyd4VMjel1WksL.png)

 

### 生产者消费者模型

![img](https://s2.loli.net/2024/08/16/8JlGQcCkZM75tf9.png)

生产者消费者界面截图

![img](https://s2.loli.net/2024/08/16/ONRgYSunrZWq2bU.png)

添加一个生产者后

![img](https://s2.loli.net/2024/08/16/LGw9iVHocMtDWdv.png)

添加两个消费者其中一个消费者因资源不够而陷入等待状态

![img](https://s2.loli.net/2024/08/16/yWwa2HvXPcGmAkI.png)

​    展示目前信息

![img](https://s2.loli.net/2024/08/16/qiylQLP3AMtoVaC.png)

​    添加生产者界面

![img](file:///C:/Users/Deepcity/AppData/Local/Temp/msohtmlclip1/01/clip_image011.png)

​    添加消费者界面

![img](https://s2.loli.net/2024/08/16/Fav1xYV2QNZMWtT.png)

​    添加新的生产者后，整体趋于平衡

### 银行家算法模型

 

![img](https://s2.loli.net/2024/08/16/NyGeHW6O1MRLbB3.png)

​    设定初始参数界面

![img](https://s2.loli.net/2024/08/16/Cp3SXbTf1lQMWAt.png)

资源设定，其中数据为手动输入

![img](https://s2.loli.net/2024/08/16/I9nyJkBK5HjZ2Xg.png)

提示处于不安全状态

![img](https://s2.loli.net/2024/08/16/8dA436bTwfGEkDq.png)

是否做出更多请求

 

![img](https://s2.loli.net/2024/08/16/4bLw3mWHU1YqF7k.png)

请求界面

![img](https://s2.loli.net/2024/08/16/Msyg1YJHG3NliUC.png)

​    数值合法性检验

![img](https://s2.loli.net/2024/08/16/X8p46WnmyRGceAK.png)

​    对另一组数据的合法判断

![img](https://s2.loli.net/2024/08/16/THZbGzdXs5itF6V.png)

​    Need矩阵的计算

### 调度算法模拟

![img](https://s2.loli.net/2024/08/16/68NQMHFiGLTyWxP.png)

​    总体界面展示

![img](https://s2.loli.net/2024/08/16/aPpQ32O4sNIoAuD.png)

添加进程数据

![img](https://s2.loli.net/2024/08/16/G3hRzXfrKnB7E6q.png)

计算FCFS结果

![img](https://s2.loli.net/2024/08/16/gBhcFGxlW1dvVQ5.png)

计算SJF结果

![img](https://s2.loli.net/2024/08/16/7qHgbuEhCAJQVyo.png)

计算SRTF结果

![img](https://s2.loli.net/2024/08/16/EbKZ7yBwtCSo2Rz.png)

计算PSNP结果

![img](https://s2.loli.net/2024/08/16/XZJ4dBO8MxveLNm.png)

计算PSP结果

![img](https://s2.loli.net/2024/08/16/CuVye3zdFGYpjXm.png)

计算RR输入时间片

![img](https://s2.loli.net/2024/08/16/FNwlQ8KgLZOfJrq.png)

时间片为1结果

 

