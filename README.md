# ultra-rare


# 大致开发计划
1. 熟悉ruoyi
2. √ ruoyi和ur的兼容性测试及调整
    * 修改了SSR的DruidProperties类名
    * 去除ruoyi的多数据源配置，使用SSR的多数据源配置。
3. √ 修改ruoyi代码生成功能
    * 生成类
    * 修改类
4. √ ur表数据的管理
5. 脚本编写页面
6. SQL编写页面
7. 图表绘制页面
8. 发布功能
9. 权限控制
10. ruoyi后台系统功能调整
11. 修改登录页面
12. 集成第三方登录
13. ssr性能测试及调整


#### 介绍
基于ssr跟datav实现的数据可视化大屏项目。
因为是基于ssr来写的，故取名为ur，即ultra rare。



# 大概功能

## 管理页面
* 大屏页面绘制
    * 展示模块
        * 数据刷新时间
        * 查询SQL
            * 动态生成SQL
        * 数据库选择
        * 样式选择 
        * 脚本编写与执行设置
    * 布局
    * 
* 大屏页面发布
    * 生成页面id与大屏页面相关数据
* 权限认证
    * 单点登录
    * 权限过滤    
## 大屏展示页面
* 根据id打开大屏页面