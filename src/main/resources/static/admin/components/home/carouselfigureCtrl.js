app.controller('carouselfigureCtrl', function ($scope,req,$state) {
    var vm = this;
    //页面初始化
    init();
    function init() {
        initSetting();
    }

    function initSetting() {
        req.post('home/carouselfigureList',{}).success(function(resp){
            	console.info(resp.data);
            	
        }).error(function(XMLHttpRequest){
        	console.log(XMLHttpRequest)
        	if(XMLHttpRequest.status == '404'){
        	    location.href('')
        	}
        });
    }

/*
    //验证用户信息
    function valid_info() {
        var valid = true;
        if (vm.user.name == '') {
            valid = false;
            layer.alert("请输入用户名");
            layer.close(vm.loadlogin);
        } else if (vm.user.pwd == '') {
            valid = false;
            layer.alert("请输入密码");
            layer.close(vm.loadlogin);
        } else if (!vm.vCodeModel) {
            valid = false;
            layer.alert("请输入验证码");
            layer.close(vm.loadlogin);
        }
        return valid;
    }*/
   /*
    //登录请求
    function req_login() {
        req.post('login/setLoginIp.do', {
            ip:vm.pomise
         }).success(function (resp) {
                    console.log(resp);
         });

        var saltPwdMix = md5.createHash(vm.user.pwd) + vm.loginSalt;
        vm.finalPwd = md5.createHash(saltPwdMix);
        req.post('login/doLogin.do', {
            userName: vm.user.name,
            password: vm.finalPwd,
            vilidate: vm.vCodeModel,
            langType:window.localStorage.lang
        }).success(function (resp) {
        		console.info(resp)
            if (resp.code == '211') {
            	$rootScope.lastlogintime=resp.data.user.lastLoginTime;
            	layer.close(vm.loadlogin);
                $rootScope.userNames  = resp.data.user.userName;
                $rootScope.userId = resp.data.user.id;
                //用户信息
                var userInfo = resp.data.user;
                //存储角色信息
                var roleInfo = resp.data.role;
                //用户权限
                vm.userRight = resp.data.right;
                //如果用户只有订户角色则不让登录后台系统
                for(var i in resp.data.allRight){
                	if(roleInfo.length == 1 && resp.data.allRight[i].id == 429){
	                   // req_userExit();
	                    layer.alert('访客、订户、一线通用户不能登录编辑系统！');
	                    req.post('login/doLogout.do',{langType:window.localStorage.lang})
	                    return;
	                }else{
	                    $rootScope.user_online = true;
	                    $state.go('role.manager.managerIndex');
	                }	
                }
            } else {
                layer.msg(resp.msg);
                // 模拟点击执行
                vm.changeValidCodeImg();
                layer.close(vm.loadlogin);
            }
        });
    }*/

});