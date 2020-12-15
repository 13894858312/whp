// pages/user/password/password.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

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

  modifyPassword: function(e) {
    var oldPassword = e.detail.value.oldPassword;
    var newPassword = e.detail.value.newPassword;
    var reinput = e.detail.value.reinput;
    if(oldPassword == '' || newPassword == '' || reinput == ''){
      wx.showToast({
        title: '请输入密码',
        icon: 'none'
      });
      return;
    }
    if (reinput != newPassword) {
      wx.showToast({
        title: '两次输入的密码不相同',
        icon: 'none'
      });
      return;
    }
    // 验证旧密码
    wx.request({
      url: 'http://121.40.243.225:8091/whp/login/login',
      data: {
        email : wx.getStorageSync('userEmail'),
        password: oldPassword
      },
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res){
        if (res.data.code != 0) {
          wx.showToast({
            title: '验证失败，请重试',
            icon: 'none'
          })
        } else {

          if (res.data.data.signature == '') {
            wx.showToast({
              title: '旧密码错误',
              icon: 'none'
            });
          } else {
            // 调用登录接口会导致原signature失效，需更新
            var signature = res.data.data.signature
            wx.setStorageSync('signature', JSON.stringify(signature));
            var userUntity = {
              'id': wx.getStorageSync('userId'),
              'password': newPassword
            }
            wx.request({
              url: 'http://121.40.243.225:8091/whp/user/updatePwd',
              data: userUntity,
              method: 'post',
              header: {
                'content-type': 'application/json',
                'signature': signature
              },
              success: function(res){
                if (res.data.code != 0) {
                  wx.showToast({
                    title: '修改密码失败，请重试',
                    icon: 'none'
                  })
                } else {
                  wx.showToast({
                    title: '修改成功',
                    icon: 'none'
                  });
                  setTimeout(function () {
                    wx.navigateBack({
                      delta: 0,
                    })
                  }, 1000);
                }
                console.log("修改密码res" + JSON.stringify(res.data))
              }
            })
          }
        }
      }
    })
  }
})