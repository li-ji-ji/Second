const app = getApp()
Component({
  properties: {
    // 这里定义了innerText属性，属性值可以在组件使用时指定
    isCheckBtn: {
      type: Array,
      value: '导航栏数据'
    },
    isShowBack: {
      type: String,
      value: "true"
    },
    stuId:{
      type:String,
      value:"true"
    }
  },
  data: {
    // 这里是一些组件内部数据
    someData: {
      statusBarHeight: app.globalData.statusBarHeight,
      titleBarHeight: app.globalData.titleBarHeight
    }
  },


  methods: {
    // 这里是一个自定义方法
    onload:function(){
    },
    /* 导航栏按钮点击事件 */
    changeList: function (res) {
      var newCheckBtn = this.data.isCheckBtn
      for (var index in newCheckBtn) {
        if (index == res.currentTarget.dataset.index) {
          newCheckBtn[index].color = '#1E90FF'
          newCheckBtn[index].arrow = true
        }
        else {
          newCheckBtn[index].color = '#f7f7f7'
          newCheckBtn[index].arrow = false
        }
      }
      this.setData({
        isCheckBtn: newCheckBtn
      })
      var myEventDetail = { url:this.properties.isCheckBtn[res.currentTarget.dataset.index].api} // detail对象，提供给事件监听函数
      var myEventOption = {} // 触发事件的选项
      this.triggerEvent('urlMsg', myEventDetail, myEventOption)
    },
  }
})