//module
var app = angular.module('myApp', ['ui.router']);
//ui.router
app.config(['$stateProvider', '$urlRouterProvider','$locationProvider', function($stateProvider, $urlRouterProvider,$locationProvider) {
	//一是建立一个默认路由，用于管理未知的URL（统一跳转到某处）
	//二是监听浏览器地址栏URL的变化，重定向到路由定义的状态中
    $urlRouterProvider.otherwise('/index');
    $stateProvider
        .state('index', {
            url:'/index',
            views : {
            	//相对命名
				//对应 index.html 中的未命名 ui-view <div ui-view/>
				//每个视图都被按照viewname@statename的方式分配为绝对名称
            	//viewname是目标模板中的ui-view对应的名称，statename是状态的名称，状态名称对应于一个目标模板
            	 '' : {
            	 	templateUrl:  'client/components/main/index.html'
            	 },
            	 'topbar@index' : {
            	 	templateUrl:  'client/components/main/topbar.html'
            	 },
            	 'main@index' : {
            	 	templateUrl:  'client/components/main/main.html'
            	 }
            }
        })
        .state('index.detail', {
        	url: '/detail',
        	views : {
        		'navDetail@index' : {
        			templateUrl:  'client/components/main/detail.html'
        		}
        	}
        })
        .state('index.about', {
            url:'/about',
            views: {
            	
            	'main@index' : {
            		templateUrl: 'client/components/main/about.html'
            	},
            }
            /*controller: 'AboutController'*/
        })
       /* .state('index.login', {
            url:'/login',
        	views: {
            	'main@index' : {
            		templateUrl: 'client/components/main/login.html'
            	},
            }
        })*/.state('login', {
            url:'/login',
        	views: {
            	'' : {
            		templateUrl: 'client/components/login/login.html'
            	},
            }
        }).state('index.usermanager', {
            url:'/usermanager',
        	views: {
            	'navDetail@index' : {
            		templateUrl: 'client/components/user/user_manager.html'
            	},
            }
        })
    //$locationProvider.html5Mode(true);
}]);
/*app.config(['$httpProvider', '$locationProvider', function ($httpProvider, $locationProvider) {
    $httpProvider.interceptors.push('HttpInterceptor');
    $httpProvider.defaults.withCredentials = true;
}]);*/