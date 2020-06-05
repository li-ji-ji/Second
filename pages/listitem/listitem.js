// pages/listitem/listitem.js
const app = getApp()
Component({
  options: {
    multipleSlots: true 
  },
  properties: {
    // 这里定义了innerText属性，属性值可以在组件使用时指定
    itemData: {
      type: Array,
      value: '传入数据'
    },
  },
  data: {
    // 这里是一些组件内部数据
    isShow:true
  },


  methods: {
    // 这里是一个自定义方法
    onload: function () {
      this.setData({
        isShow: false
      })
    },
    /* 手风琴点击事件 */
    itemClick:function(res){
      this.setData({
        isShow:!this.data.isShow
      })
    }
  }
})