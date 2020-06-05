// pages/login/login.js
var app = getApp();
var host = app.globalData.host;
Page({

    /**
     * 页面的初始数据
     */
  data: {
      title: '用户绑定',
        // showLogin: false
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        var that = this;
        wx.getSystemInfo({
            success: function(res) {
              //获取当前设备信息
              // console.log(res)
              that.setData({
                  height: res.screenHeight
              })
            }

        });
        // console.log("that.data.height")
        // console.log(that.data.height)

        that.setData({
            navHeight: app.globalData.statusBarHeight + app.globalData.titleBarHeight
        })
        // console.log(that.data.navHeight)
       
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function() {

    },


    applyForm: function(res) {
        var that = this;
        var app = getApp();
        // console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        // console.log(res.detail.value);
        // console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        var information = res.detail.value;
        if (information.name == "" || information.school == "" || information.number == "" || information.Professional == "") {
            wx.showToast({
                title: '请检查信息是否完整!',
                // image: '/images/Tpis.png'
            })
        } else {
            wx.login({
              success: res => {
                if (res.code) {
                  console.log(res)
                  wx.request({
                    url: host +'/stu/getOpenId',
                    method: 'POST',
                    data: {
                      code: res.code,
                      sn: information.sn,
                      password: information.password
                    },
                    header: {
                      'content-type': 'application/x-www-form-urlencoded'
                    },
                    success(res) {
                      console.log(res);
                      if (res.data.openid != "" || res.data.openid != null) {
                        // 登录成功
                        wx.setStorageSync("openid", res.data.openid);//将用户id保存到缓存中
                        wx.setStorageSync("session_key", res.data.session_key);//将session_key保存到缓存中
                        wx.setStorageSync("userInfo", res.data.stuInfo);//将用户信息保存到缓存中
                        wx.setStorageSync("loginFlag", true);//将登录态保存到缓存中
                        wx.navigateBack({
                        })
                      } else {
                        // 登录失败
                        // TODO 跳转到错误页面，要求用户重试
                        return false;
                      }
                    }
                  })
                } else {
                  console.log('获取用户登录态失败！' + res.errMsg)
                }
              }
            })
            console.log(information)
            // wx.request({
            //     url: host+'/stu/studentLogin',
            //     data: information,
            //     header: { 'content-type': 'application/x-www-form-urlencoded' },
            //     method: 'post',
            //     dataType: 'json',
            //     responseType: 'text',
            //     success: function(res) {
            //         // console.log("////////////////////////////////////////////////////////////////")
            //         // console.log(res)
            //         // console.log("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^66")
            //         // console.log(res.data);
            //         if (res.data.id > 0) {
            //             app.globalData.user = res.data;
            //             wx.setStorage({
            //                 key: 'userInfo',
            //                 data: res.data,
            //             })
            //             wx.navigateBack({
            //             })
            //         } else {
            //             wx.showToast({
            //                 title: '绑定失败!',
            //                 image: '/images/Tpis.png'
            //             })
            //         }
            //     },
            //     fail: function(res) {
            //         wx.showToast({
            //             title: '绑定异常!',
            //             image: '/images/Tpis.png'
            //         })
            //     },
            //     complete: function(res) {

            //     },
            // })

        }
    },

    login: function(res) {
        var that = this;
        console.log("!!!!!!!!!!!!!!!!!!!!!!!!!");
        console.log(res.detail.userInfo);
        console.log("!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (res.detail.userInfo) {
            wx.setStorage({
                key: 'userInfo',
                data: res.detail.userInfo,
            })
            wx.reLaunch({
                url: '/pages/homePage/homePage'
            })
        }
    }
})