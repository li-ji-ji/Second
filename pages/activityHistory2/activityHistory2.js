// pages/activityHistory2/activityHistory2.js
var app = getApp();
var host = app.globalData.host;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    title: '活动记录',
    nowList: '0',
    hasUserInfo: false,
    checkBtn: [
      {
        color: '#1E90FF',
        title: '未开始',
        api: '/AssoActivity/getActByStuIdSigned',
        arrow: true
      },
      {
        color: '',
        title: '进行中',
        api: '/AssoActivity/getActByStuIdStarted',
        arrow: false
      },
      {
        color: '',
        title: '已结束',
        api: '/AssoActivity/getActByStuIdFinished',
        arrow: false
      }
    ],
    historyList: [],
    windowHeight: wx.getSystemInfoSync().windowHeight,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        //console.log("本地缓存")
        //console.log(res.data.sn)
        that.setData({
          stuId: res.data.sn
        })
      },
      fail(res) { //否则，进入登陆界面
        //console.log(res.data);
        wx.showToast({
          title: '未绑定用户',
        })
      }
    })
    wx.getStorage({
      key: "userInfo",
      //获取学生学号
      success: function (res) {
        //console.log("本地缓存")
        //console.log(res)
        that.setData({
          stuId: res.data.sn
        });
        //根据学生学号，获取已报名活动
        wx.request({
          url: host +that.data.checkBtn[0].api,
          data: {
            stuId: that.data.stuId
          },
          header: {
            'content-type': 'application/json'
          },
          method: 'GET',
          dataType: 'json',
          responseType: 'text',
          success: function (res) {
            //console.log('~~~~~~~~~~')
            //console.log(res.data)
            that.setData({
              historyList: res.data
            })

          }
        });
      },
    })
  },
  getList: function (res) {
    var that = this
    // console.log(res.detail.url)
    wx.request({
      url: host+res.detail.url,
      data: {
        stuId: that.data.stuId
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      success: function (res) {
        //console.log(res.data)
        that.setData({
          historyList: res.data
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})