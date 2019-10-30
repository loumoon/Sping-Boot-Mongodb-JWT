# Sping-Boot-Mongodb-JWT
A project to implement permission control function, based on Spring Boot, MongoDB and JWT.

前后端是RESTful的交互方式，因此使用Postman工具进行效果演示。

首先，注册一个用户：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gbae6xe1j31e80u0td0.jpg)

检查MongoDB的情况：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gaqlogkxj31ao0skgyh.jpg)

注册成功，现在用这个账户进行登录：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8garhvmdaj31e80u04kw.jpg)

登录成功后端返回了一串token，下次请求将这个token放在请求头中，注意/user/test接口的请求方法是GET：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gawnv3xwj31e80u0aut.jpg)

可以看到，用户的角色role为3，对应Role.OPERATOR，而/user/test接口上的注解是@MaintainerToken和@ManagerToken，说明只有Maintainer和Manager具有访问权限，而该用户权限不够。

重新注册一个role为1，对应Role.MANAGER的用户，登录后，请求/user/test接口：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gb3pf3nfj31e80u0wym.jpg)

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gb4dlp5cj31e80u0qpk.jpg)

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gb5ds222j31e80u04lf.jpg)

可以看到，这个用户具有访问接口/user/test的权限，请求成功。

把token的第一个字符'e'删掉，再发送请求，后端返回令牌不合法的错误响应：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gb7d3aiij31e80u04hm.jpg)

不带token，再发送请求，后端返回令牌不存在的错误响应：

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g8gb8yzzk6j31e80u0qm0.jpg)

