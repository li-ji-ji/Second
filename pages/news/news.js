//news.js

var util = require('../../utils/util.js')
var app = getApp();
var host = app.globalData.host;
Page({
    data: {
        title: '审核记录',
        msg: [],
        time: '2019-08-26T00:00:00.000+0000',
    },
    GMTToStr: function (time) {
      let date = new Date(time)
      let Str = date.getFullYear() + '-' +
        (date.getMonth() + 1) + '-' +
        date.getDate() + ' ' +
        date.getHours() + ':' +
        date.getMinutes() + ':' +
        date.getSeconds()
      return Str
    },
    onLoad:function(){
      var that=this
      wx.getStorage({
          //获取本地缓存      
          key: "userInfo",
          success: function(res) {
              console.log("本地缓存")
              // console.log(res.data.sn)
                    
            wx.request({
              url: host+'/apply/getApplyCheckedByDateBetweenAndStuId',
              data: {
                startTime:'2019-08-22 20:30',
                stuId:JSON.parse(res.data).sn
              },
              header: {
                'content-type': 'application/json'
              },
              method: 'GET',
              dataType: 'json',
              responseType: 'text',
              success: function (res) {
                console.log('switchNav~~~~~~~~~~')
                var applyList = res.data
                //console.log(applyList)
                //转换日期格式，读取并重新封装佐证材料内容
                console.log(res.data)
                console.log(applyList)
                for(var i=0;i<applyList.length;i++){
                  applyList[i].applyTime = (new Date(applyList[i].applyTime)).toLocaleDateString()
                  applyList[i].contentText = (JSON.parse(applyList[i].supportDoc)).docText
                  applyList[i].contentImg = (JSON.parse(applyList[i].supportDoc)).docImgs
                }
                console.log(applyList)
                that.setData({
                  msg: applyList
                })
              }
            });
        }, 
        fail(res) { //否则，进入登陆界面
          // console.log("无缓存");
          that.setData({
            joinStatus: 1
          })
        }
      })
    }
})