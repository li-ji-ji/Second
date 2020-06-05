//index.js
//api √
//获取应用实例
var app = getApp();
var host = app.globalData.host;

Page({
    data: {
        title: '首页',
        otherTitle: '分类',
        listTitle: '活动列表',
        indicatorDots: " #ccc",
        autoplay: true,
        interval: 2000,
        duration: 1000,
        test: "1111",
        imgUrls: [
            'http://www.qziedu.cn/d/file/p/2019-04-19/ae256701158a3ea9762cb2f9ece856a7.png',
            'http://www.qziedu.cn/d/file/p/2019-04-19/b46196df8f2be8e790b2a315f46e5d9c.png',
            'http://www.qziedu.cn/d/file/p/2019-04-19/876f49first.png'
        ], //幻灯片图片
        kinds: [], //分类
        activitys: [] //活动
    },
    //事件处理函数
    onLoad: function() {
        var _that = this;
        //分类请求
        wx.request({
          url: host +'/applyKind/getApplyKindByPid', //仅为示例，并非真实的接口地址
            data: {
                pId: '0'
            },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                _that.setData({
                    kinds: res.data
                })
                console.log(res.data)
            }
        });

        // 活动列表请求
        wx.request({
          url: host +'/AssoActivity/getActByStartTimeAndPartStatus?partStatus=1',
            header: {
                'content-type': 'application/json' // 默认值
            },
            success(res) {
                var activitys = res.data
                for (let index = 0; index < activitys.length; index++) {
                    activitys[index].activityStartTime = activitys[index].activityStartTime.substr(0, 19).replace('T', ' ');;
                    console.log(activitys[index].activityStartTime)
                }
                _that.setData({
                    activitys: activitys
                })
                console.log('活动列表请求')
                console.log(res.data)
            }
        })
    },
    //分类区域点击跳转函数
    jumpPage: function(e) {
        var x = e.currentTarget.dataset.type
        console.log(e);
        console.log(this.data.kinds[x].id);
        wx.navigateTo({
            url: '../kind/kind?nameData=' + this.data.kinds[x].kindName + '&idData=' + this.data.kinds[x].id
        });
    },
    //活动列表跳转函数
    jumpActivitys: function(e) {
        console.log("活动列表链接跳转")
        console.log(e)
        var x = e.currentTarget.dataset.index
        wx.navigateTo({
            url: '../activity/activity?nameData=' + this.data.activitys[x].activityName + '&idData=' + this.data.activitys[x].id + '&activityId=' + this.data.activitys[x].activityId
        })

    },

    getUserInfo: function(e) {
        console.log(e)
        app.globalData.userInfo = e.detail.userInfo
        this.setData({
            userInfo: e.detail.userInfo,
            hasUserInfo: true
        })
    }
})