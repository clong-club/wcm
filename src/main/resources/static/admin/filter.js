angular.module('myFilter', [])
    
    //日志管理-操作类型
    .filter('logOperateTypeFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "增";
                    break;
                case 1:
                    result = "删";
                    break;
                case 2:
                    result = "改";
                    break;
            }
            return result;
        }
    })
     
    //消息管理-状态类型
    .filter('msgManageStatusFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "不发布";
                    break;
                case 1:
                    result = "发布";
                    break;
            }
            return result;
        }
    })

    //消息管理-状态类型
    .filter('msgManageTipIdFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "不置顶";
                    break;
                case 1:
                    result = "置顶";
                    break;
            }
            return result;
        }
    })

    //消息管理-短信状态类型
    .filter('phoneMsgStatusFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "发送成功";
                    break;
                case 1:
                    result = "保存成功";
                    break;
                case 2:
                    result = "发送失败";
                    break;
            }
            return result;
        }
    })

    //消息管理-站内信操作状态
    .filter('msgWorkStatusFilter', function () {
        return function (input) {
            if (parseInt(input) == 0) {
                return '已读';
            } else if (parseInt(input) == 1) {
                return '未读';
            }
        }
    })


    //消息管理-接受状态
    .filter('msgMailReceiverFilter', function () {
        return function (input, receiver) {
            var flag1 = -1;
            var flag2 = -1;
            if (input == null || input == "" || typeof(input) == "undefined") {
                flag1 = 0;
            }
            if (receiver == null || receiver == "" || typeof(receiver) == "undefined") {
                flag2 = 0;
            }
            if (flag1 == 0 && flag2 != 0) {
                return receiver;
            } else if (flag1 != 0 && flag2 == 0) {
                return input;
            }
        }
    })

    //稿件编辑状态 0否，1是
    .filter('isLockFilter', function () {
        return function (input) {
            if (parseInt(input) == 0) {
                return '否';
            } else if (parseInt(input) == 1) {
                return '是';
            } else {
                return '否';
            }
        }
    })

    //用户管理-用户状态
    .filter('userManageTypeFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "已开通";
                    break;
                case 1:
                    result = "正申请";
                    break;
                case 2:
                    result = "已删除";
                    break;
                case 3:
                    result = "已禁用";
                    break;
            }
            return result;
        }
    })

    //稿件-操作记录
    .filter('flowTypeFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case -1:
                    result = "保存稿件";
                    break;
                case 0:
                    result = "发稿提交";
                    break;
                case 1:
                    result = "一审提交";
                    break;
                case 2:
                    result = "二审提交";
                    break;
                case 3:
                    result = "三审签发";
                    break;
                case 4:
                    result = "补签";
                    break;
                case 5:
                    result = "内部留资";
                    break;
                case 6:
                    result = "撤稿";
                    break;
                case 7:
                    result = "上架";
                    break;
                case 8:
                    result = "删除";
                    break;
                case 9:
                    result = "推送";
                    break;
                case 10:
                    result = "编辑";
                    break;
                case 11:
                    result = "一审退稿";
                    break;
                case 12:
                    result = "二审退稿";
                    break;
                case 13:
                    result = "三审退稿";
                    break;
                case 14:
                    result = "取回";
                    break;
                case 15:
                    result = "稿件合并";
                    break;
                case 16:
                    result = "强制解锁";
                    break;
                case 17:
                    result = "彻底删除";
                    break;
                case 18:
                    result = "稿件恢复";
                    break;
                case 19:
                    result = "修改一审编辑";
                    break;
            }
            return result;
        }
    })

   
    //识别html格式
    .filter('trustHtml', function ($sce) {
        return function (input) {
            return $sce.trustAsHtml(input);
        }
    })
    //处理广告位文件上传提示
    .filter('adFileUploadTipFilter', function () {
        return function (input, length, tip) {
            if (!input) {
                return tip;
            } else {
                if (input.length > length) {
                    return input.substr(0, length) + "...";
                } else {
                    return input;
                }
            }
        }
    })
    //过滤是否启用敏感词
    .filter('sensitiveFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "启用";
                    break;
                case 1:
                    result = "禁用";
                    break;
            }
            return result;
        }
    })

    //订单管理-价格状态
    .filter('omPriceStateFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "待付款";
                    break;
                case 1:
                    result = "取消付款";
                    break;
                case 2:
                    result = "已付款";
                    break;
            }
            return result;
        }
    })

    //权限分类
    .filter('rightSortsFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 1:
                    result = "管理功能";
                    break;
                case 2:
                    result = "稿件编辑";
                    break;
                case 3:
                    result = "数据统计";
                    break;
            }
            return result;
        }
    })

    //横向导航权限图标过滤
    .filter('rightIconUrlFilter', function () {
        return function (input, rightId) {
            var result = "";
            switch (parseInt(rightId)) {
                case 123:
                    result = "admin/assets/img/role/zxs_ld_but_picb_03.png";
                    break;
                case 245:
                    result = "admin/assets/img/role/zxs_ld_but_picb_05.png";
                    break;
                case 146:
                    result = "admin/assets/img/role/zxs_ld_but_picb_07.png";
                    break;
                case 276:
                    result = "admin/assets/img/role/zxs_ld_but_picb_09.png";
                    break;
                case 210:
                    result = "admin/assets/img/role/zxs_ld_but_picb_11.png";
                    break;
                case 266:
                    result = "admin/assets/img/role/zxs_ld_but_pica_15.png";
                    break;
                case 110:
                    result = "admin/assets/img/role/zxs_ld_but_pica_03.png";
                    break;
                case 113:
                    result = "admin/assets/img/role/zxs_ld_but_pica_05.png";
                    break;
                case 121:
                    result = "admin/assets/img/role/zxs_ld_but_pica_07.png";
                    break;
                case 270:
                    result = "admin/assets/img/role/zxs_ld_but_pica_07.png";
                    break;
                case 65:
                    result = "admin/assets/img/role/zxs_ld_but_pica_15.png";
                    break;
                case 416:
                    result = "admin/assets/img/role/zxs_ld_but_pica_07.png";
                    break;
                case 417:
                    result = "admin/assets/img/role/zxs_ld_but_pica_13.png";
                    break;
                case 456:
                    result = "admin/assets/img/role/zxs_ld_but_pica_05.png";
            }
            return result;
        }
    })
    //文件大小的单位（Bytes、Kb、Mb、Gb、Tb）
    .filter('Filesize', function () {
        return function (size) {
            if (isNaN(size))
                size = 0;

            if (size < 1024)
                return size + ' Bytes';

            size /= 1024;

            if (size < 1024)
                return size.toFixed(2) + ' Kb';

            size /= 1024;

            if (size < 1024)
                return size.toFixed(2) + ' Mb';

            size /= 1024;

            if (size < 1024)
                return size.toFixed(2) + ' Gb';

            size /= 1024;

            return size.toFixed(2) + ' Tb';
        };
    })
    //用户结算方式
    .filter('payWayFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "充值";
                    break;
                case 1:
                    result = "合同";
                    break;
                case 2:
                    result = "充值与合同";
                    break;
            }
            return result;
        }
    })
    //生成订单状态
    .filter('orderStatusFilter', function () {
        return function (input) {
            var result = "";
            switch (parseInt(input)) {
                case 0:
                    result = "待付款";
                    break;
                case 1:
                    result = "取消付款";
                    break;
                case 2:
                    result = "已付款";
                    break;
            }
            return result;
        }
    })

