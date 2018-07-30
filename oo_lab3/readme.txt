1、各个class的说明
   1）elemain
     蕴含了主函数的类
   2）cntroller
    上一次实验的调度器
   3）controller_strong
    继承自上一次的调度器，重写了调度部分的功能。同时，对于toString的重写也在这个类里面，支持输出的功能。
   4）elevat
   上一次实验中的电梯类，可以支持初始化、调度以及位置的查询的功能。
   5）building
   记录了关于同质请求判定的相关数据
   6）ele_strong
   作为与elevat的接口的功能。
   7）req
   指令类，支持指令的各种信息的查询功能。
   8）request_queue
   指令队列，支持查询、删除等功能。


2、部分输入输出的说明
   1）输入规范
    除了指导书中规定的以外，我的每行读入一个指令，最后以“end”（不包括引号）结尾，程序会自动过滤掉tab以及半角英文输入法下的空格，不支持“-0”（负0）。
   2）输出规范
    除了指导书中规定的以外，对于正确的指令（合法指令）：输出的指令部分（就是中括号括起来的那种）会自动去掉输入的指令中间的tab或者空格以及正号。正则匹配错误（就是除了时间类错误、首条指令错误以及爆int型的错误以外的错误）会将原有指令直接输出，以外的错误会去掉括号以及正号输出。详见下面的几个样例

kaghlfdnvksffgksakald
INVALID[kaghlfdnvksffgksakald]（完全不符合个数规范，直接输出报错）
(fsdkjgajlga)
INVALID[(fsdkjgajlga)]（完全不符合个数规范，直接输出报错）
(ER,1,+753847528658)
INVALID[ER,1,753847528658]（爆int型错误，所以中括号里没有小括号）
ajskfdjak a sdfkahsfdakvd kj
INVALID[ajskfdjakasdfkahsfdakvdkj]（过滤掉了空格）
(ER,+2,+1)
INVALID[ER,2,1]（开始时间不对，没有小括号，过滤掉了正号）

    此外，如果是正常执行的程序，也会自动过滤掉小括号以及空格、tab、“+”键，再用中括号括起来输出。