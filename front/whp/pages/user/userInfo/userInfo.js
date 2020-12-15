// pages/user/userInfo/userInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    signature: '',
    userId: '',
    userEmail: '',
    userEntity: undefined
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      signature: wx.getStorageSync('signature'),
      userId: wx.getStorageSync('userId'),
      userEmail: wx.getStorageSync('userEmail')
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
    if (wx.getStorageSync('signature') != '') {
      var id = wx.getStorageSync('userId')
      wx.request({
        url: 'http://121.40.243.225:8091/whp/user/get?id=' + id,
        method: 'post',
        header: {
          'content-type': 'application/json',
          'signature': wx.getStorageSync('signature')
        },
        success: function(res){
          if (res.data.code != 0) {
            wx.showToast({
              title: '获取数据失败',
              icon:'none'
            })
          }
          else {
            that.setData({
              userEntity: res.data.userEntity
            });
          }
        }
      });
    }
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

  },

  // 用户登录
  login: function(e) {
    var that = this;
    var email = e.detail.value.email;
    var pswd = e.detail.value.password;
    if(email == '' || pswd == ''){
      wx.showToast({
        title: '请输入登录邮箱和密码',
        icon: 'none'
      });
      return;
    }
    wx.request({
      url: 'http://121.40.243.225:8091/whp/login/login',
      data: {email : email, password: pswd},
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res){
        if (res.data.code != 0) {
          wx.showToast({
            title: '登录失败，请重试',
            icon: 'none'
          })
        } else {
          if (res.data.data.userEntity == null) {
            wx.showToast({
              title: '用户名或密码错误',
              icon: 'none'
            });
          } else {
            // 缓存signature和id
            wx.setStorageSync('signature', res.data.data.signature);
            wx.setStorageSync('userId', res.data.data.userEntity.id);
            wx.setStorageSync('userEmail', email)
            // 弹框
            wx.showToast({
              title: '欢迎您，' + res.data.data.userEntity.name,
              icon: 'none'
            })
            // 刷新页面
            setTimeout(function () {
              that.onShow();
              that.onLoad();
            }, 1000)
          }
        }
        console.log(res.data)
      },
      fail: function(res){
        console.log("登录出错，错误信息：" + res);
      }
    });
  },

  bindModifyPassword: function() {
    wx.redirectTo({
      url: '/pages/user/password/password'
    })
  }
})