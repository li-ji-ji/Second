// pages/applyHistory2/applyHistory2.js
var app = getApp();
var host = app.globalData.host;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    title: '申请书',
    nowList: '0',
    hasUserInfo: false,
    APIs: ['/apply/getApplyByStuIdAndCheckStatus?checkStatus=0',
      '/apply/getApplyByStuIdAndCheckStatus?checkStatus=1'
    ],
    checkBtn:[
      {
        color:'#1E90FF',
        title:'已审核',
        api: '/apply/getApplyByStuIdAndCheckStatus?checkStatus=0',
        arrow:true
      },
      {
        color: '',
        title: '审核中',
        api: '/apply/getApplyByStuIdAndCheckStatus?checkStatus=1',
        arrow: false
      },
      {
        color: '',
        title: '历史记录',
        api: '/apply/getApplyByStuId',
        arrow: false
      }
    ],
    historyList:[],
    windowHeight: wx.getSystemInfoSync().windowHeight,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this
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
      //获取本地缓存 
      key: "userInfo",
      success: function (res) {
        console.log("本地缓存")
        console.log(res.data.sn)

        that.setData({
          stuId: res.data.sn
        });
        wx.request({
          url: host+that.data.checkBtn[0].api,
          data: {
            stuId: res.data.sn
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
    })
  },

  getList:function(res){
    var that=this
    wx.request({
      url: host+res.detail.url,
      data:{
        stuId:this.data.stuId
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      success:function(res){
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