// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName'), // 如需尝试获取用户信息可改为false,
    openId : ""
  },
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad() {
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }, 
  goOn : function() {
    console.log("go on click")
    this.getOpenId()
    console.log(this.openId)
    wx.navigateTo({
      url : "/pages/apps/index",
      success: function() {
        console.log("navigate to demo-01 success")
      },
      fail: function() {
        console.log("navigate to demo-01 fail")
      }
    })
    
  },
  getOpenId: function () {
    var that = this
    console.log('get openId')
    wx.login({
      success(res) {
        console.log(res)
        wx.request({
          url: 'http://127.0.0.1:9610/wechat/openid',
          data: {
            code: res.code,
          },
          method: "GET",
          success(res){
            console.log('get open id : ' + res.data.data)
            that.setData({
              openId: res.data.data
            })
          },
          fail(){
            console.log('get openid fail')
          }
        })
      }
    })   
  }
})
