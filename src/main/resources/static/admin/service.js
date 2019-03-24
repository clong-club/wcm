angular.module('myServices', [])
    .constant('baseUrl', '/')
    .factory('req', function ($http, baseUrl) {
        var transform = function (data) {
            return $.param(data);
        };
        var postConfig = {
            headers:{'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transform
        };

        //GET 请求
        function get(url, data) {
            return $http.get(baseUrl + url, {
                params: data
            });
        }

        //POST 请求
        function post(url, data) {
            var data = data || {}
            return $http.post(
                baseUrl + url,
                data,
                postConfig
            );
        }

        return {
            get:      get,
            post:     post
        }
    })
    .factory('modalOperate',function($rootScope){
        //模态框显示
        function modalShow(modalId){
            $('#' + modalId).show();
            //模态框遮罩层显示
            $rootScope.layerIfShow = true;
        }
        //模态框隐藏
        function modalHide(modalId){
            $('#' + modalId).hide();
            //模态框遮罩层隐藏
            $rootScope.layerIfShow = false;
        }
        return {
            modalShow: modalShow,
            modalHide: modalHide
        }
    })
    //获取我的值班级别
    .factory('getMyDuty',function(req){
        //获取我的值班级别
        function req_getMyDuty(callback){
            req.post('groupPicCtro/getMyDuty.do',{langType: window.localStorage.lang}).success(function(resp){
                if(resp.code == '211'){
                    if (callback) callback(resp.data);
                }else{
                    console.log(resp.msg);
                }
            });
        }
        return {
            req_getMyDuty: req_getMyDuty
        }
    })
    //拖拽模态框
    .factory('allModalMove',function(){
        function modalMove(dragDiv,tagDiv){      //传入拖拽发生id和被拖拽id，如果相同，则本体就是按钮和拖拽对象

            var dragDiv = document.getElementById(dragDiv);
            var tagDiv = document.getElementById(tagDiv);
            var tagContainer = document;
            var e,offsetT,offsetL,downX,downY,moveX,moveY;

            dragDiv.onmouseover = function(e){
                this.style.cursor = "move";
            }

            dragDiv.onmousedown = function(e){
                e = e||window.event;
                offsetT = tagDiv.offsetTop;
                offsetL = tagDiv.offsetLeft;
                downX = e.clientX;
                downY = e.clientY;

                dragDiv.onmouseup = function(e){
                    tagContainer.onmousemove = function(){return false;}
                }

                tagContainer.onmousemove = function(e){
                    e = e||window.event;
                    moveX = e.clientX;
                    moveY = e.clientY;
                    tagDiv.style.top = offsetT + (moveY - downY) + "px";
                    tagDiv.style.left = offsetL + (moveX - downX) + "px";
                }
            }
        }
        return {
            modalMove: modalMove
        }
    })
    //获取站内信
    .factory('getsendMsg',function(req){
        ///获取站内信
        function req_getSendMsg(callback){
            req.post('station/show.do',{}).success(function(resp){
                if(resp.code == '211'){
                    if (callback) callback(resp.data);
                }else{
                    console.log(resp.msg);
                }
            });
        }
        return {
            req_getSendMsg: req_getSendMsg
        }
    })
    //提供给不同控制器的通信
    .factory("EventService", function () {
        var onEventFunc = {};
        return {
            on: function (type, f) {
                //事件绑定
                onEventFunc[type] = f;
            }, trigger: function (type, data) {
                //触发事件
                for (var item in onEventFunc) {
                    if (item == type)
                        onEventFunc[item](data);
                }
            }
        }
    })
    // 存储专题栏目数据
    .factory("lanmuShareDataService",function(){
        return {
            lanmuData:[{
                id:'',
                name: '',
                lanmuNo:'',
                showWay:0,
                typeId:0,
                keyWords:'',
                url:'',
                pic:'',
                zhanshuCount:'',
                words:'',
                cpLanmuList:[],
                moreLanmuPictures:[],
                cpLanmuPictures:[],
                cpNoticesList:[]
            }]
        }
    })
    // 存储专题栏目数据
    .factory("lanmuAdvertisingDataService",function(){
        return {
            lanmuData:[{
                id:'',
                title: '',
                number:'',
                showWay:0,
                topicId:'',
                banager:"",
                content:"",
                createTime:''
            }]
        }
    })

    .factory('myPaginationService',function(){


            var getPageData = function(pageObject,page){
                pageObject.currentPage = page;
                if (pageObject.currentPage > 1 && pageObject.currentPage < pageObject.totalPage) {
                     pageObject.pages = [
                         pageObject.currentPage - 1,
                         pageObject.currentPage,
                         pageObject.currentPage + 1
                     ];
                } else if (pageObject.currentPage == 1 && pageObject.totalPage == 1) {
                    pageObject.pages = [
                        1
                    ];
                } else if (pageObject.currentPage == 1 && pageObject.totalPage == 2) {
                    pageObject.pages = [
                        1,2
                    ];
                } else if (pageObject.currentPage == 1 && pageObject.totalPage > 2) {
                    pageObject.pages = [
                        pageObject.currentPage,
                        pageObject.currentPage + 1,
                        pageObject.currentPage + 2
                    ];
                } else if (pageObject.currentPage == pageObject.totalPage && pageObject.totalPage == 1) {
                    pageObject.pages = [
                        1
                    ];
                } else if (pageObject.currentPage == pageObject.totalPage && pageObject.totalPage == 2) {
                    pageObject.pages = [
                        1,2
                    ];
                } else if (pageObject.currentPage == pageObject.totalPage && pageObject.totalPage > 2) {
                    pageObject.pages = [
                        pageObject.currentPage - 2,
                        pageObject.currentPage - 1,
                        pageObject.currentPage
                    ];
                }
            };

            var service = {

                upPageClick: function(pageObject,page){
                    if(pageObject.currentPage == 1){
                        return;
                    };
                    pageObject.currentPage --;
                    getPageData(pageObject,page);
                },

                downPageClick: function(pageObject,page){
                    if(pageObject.currentPage >= pageObject.totalPage){
                        return;
                    };
                    pageObject.currentPage ++;
                    getPageData(pageObject,page);
                },

                showFirstPageContent: function(pageObject,page){
                    pageObject.currentPage = 1;
                    getPageData(pageObject,page);
                },

                showLastPageContent: function(pageObject,page){
                    pageObject.currentPage = pageObject.totalPage;
                    getPageData(pageObject,page);
                },

                showCurrentPageContent: function(pageObject,page){
                    pageObject.currentPage = page;
                    getPageData(pageObject,page);
                }
            };
            return service;
    })


