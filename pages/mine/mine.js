//index.js
//获取应用实例
var app = getApp();
var host = app.globalData.host;


Page({
    data: {
        score:0,
        title: '我的',
        rows: [
          {
            name: '申请书'
          },
          {
            name: '活动'
          },
          {
            name: '用户绑定'
          }
        ],
        route: ['../applyHistory2/applyHistory2',
          '../activityHistory2/activityHistory2',
          '../login/login'
        ],
        windowHeight: wx.getSystemInfoSync().windowHeight,
    },
    onLoad: function(options) {
        var that = this
        that.getScore()
    },
    onShow: function(options) {
      var that = this
      that.getScore()
    },
    showRow: function(e) {
        var that = this
        console.log(e.currentTarget.dataset.index)
        wx.navigateTo({
            url: that.data.route[e.currentTarget.dataset.index]
        });
    },
    getScore:function(){
      console.log(wx.getStorageSync('userInfo'))
      let stuId = (JSON.parse(wx.getStorageSync('userInfo')))['sn']
      console.log(stuId)
      var that = this;
      wx.request({
        url: host +'/apply/getApplyPassByStuId',
        method: 'POST',
        data: {
          stuId:stuId
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success(res) {
          that.setData({
            score:res['data']['score']
        })
        }
      })
    }
})