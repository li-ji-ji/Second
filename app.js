//app.js
//api√
App({
  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function() {
    // 展示本地存储能力
    var news = wx.getStorageSync('news') || []
    news.unshift(Date.now())
    wx.setStorageSync('news', news)
    //获取手机信息
    var that = this
    
    // 检查登录状态
    that.checkLoginStatus();
    
    wx.getSystemInfo({
      success: function(res) {
        that.globalData.platform = res.platform
        let totalTopHeight = 68
        if (res.model.indexOf('iPhone X') !== -1) {
          totalTopHeight = 88
        } else if (res.model.indexOf('iPhone') !== -1) {
          totalTopHeight = 64
        }
        that.globalData.statusBarHeight = res.statusBarHeight
        that.globalData.titleBarHeight = totalTopHeight - res.statusBarHeight
      },
      failure() {
        that.globalData.statusBarHeight = 0
        that.globalData.titleBarHeight = 0
      }
    })

    // // 获取存储信息，判断用户是否登陆过
    // wx.getStorage({
    //     key: 'userInfo',
    //     success(res) { //若有登陆过，则进入首页
    //         that.globalData.userInfo = res.data;
    //         console.log(that.globalData.userInfo);
    //         wx.reLaunch({
    //           url: '/pages/homePage/homePage'
    //         })
    //     },
    //     fail(res) { //否则，进入登陆界面
    //         console.log(res.data);
    //         wx.reLaunch({
    //             url: '/pages/login/login'
    //         })
    //     }
    // })
  },
  // 检查本地 storage 中是否有登录态标识
  checkLoginStatus: function() {
    let that = this;
    let JWTString = wx.getStorageSync('session_key')
    console.log(JWTString)
    if(JWTString != null && JWTString != undefined && JWTString!=""){
      wx.request({
        url: " 'http://39.105.70.238/second/api/stu/checkJWT",
        data: {
          JWTString: JWTString
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'post',
        dataType: 'json',
        responseType: 'text',
        success: function(res) {
          console.log(res['data']['code'])
          if(res['data']['code'] == 'true'){
            console.log("用户登录未过期")
          }else{
            wx.clearStorage(wx.clearStorageSync)
            wx.showToast({
              title: '请重新进行用户绑定',
              icon: 'none'
            })
          }
        },
        fail: function(res) {
          wx.clearStorage(wx.clearStorageSync)
          wx.showToast({
            title: '请重新进行用户绑定',
            icon: 'none'
          })
        },
        complete: function(res) {

        },
      })
    }else{
      wx.clearStorage(wx.clearStorageSync)
      wx.showToast({
        title: '用户未绑定',
        icon: 'none'
      })
    }
  },
  //用户登陆
  userLogin: function() {
    var that = this;
    if (that.globalData.user.id > 0) {} else {
      wx.login({
        success(res) {
          // console.log("++++++++++++++++++++++++++")
          // console.log(res)
          // console.log(res.code)
          if (res.code) {
            //发起网络请求
            wx: wx.request({
              url: 'https://qzimp.cn/api/csp-authority/bg/studentapi/login',
              data: {
                code: res.code
              },
              header: {
                'content-type': 'application/x-www-form-urlencoded'
              },
              method: 'post',
              dataType: 'json',
              responseType: 'text',
              success: function(res) {
                that.globalData.user = res.data
              },
              fail: function(res) {
                wx.showToast({
                  title: '绑定失败!',
                  icon: 'none'
                })
              },
              complete: function(res) {

              },
            })
          }
        }
      })
    }
  },


  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onshow: function(option) {
    var that = this;
    var userLogin = that.userLogin();
    userLogin;
  },
  globalData: {
    userInfo: {
      avatarUrl: "",
      gender: "",
      nickName: "",
    },
    user: {
      id: 0
    },
    host: 'http://39.105.70.238/second/api',
  }
})