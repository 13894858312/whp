// pages/user/userInfo/userInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userEmail: '',
    userEntity: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
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
    var that = this;
    that.setData({
      userEmail: wx.getStorageSync('userEmail')
    })
    if (wx.getStorageSync('signature') != '') {
      console.log(wx.getStorageSync('signature'))
      var id = wx.getStorageSync('userId')
      wx.request({
        url: 'https://chem.ufeng.top/whp/user/get?id=' + id,
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
              userEntity: res.data.data
            });
          }
          console.log(res.data)
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
      url: 'https://chem.ufeng.top/whp/login/login',
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
    wx.navigateTo({
      url: '/pages/user/password/password'
    })
  },

  bindLogOut: function() {
    wx.removeStorage({
      key: 'userId',
    })
    wx.removeStorage({
      key: 'userEmail',
    })
    wx.removeStorage({
      key: 'signature',
    })
    var that = this;
    that.setData({
      userEntity: null,
      userEmail: ''
    })

    wx.showToast({
      title: '退出成功',
      icon: 'none'
    })
  }
})