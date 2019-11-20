// pages/admin/index/index.js

Page({
  data: {
    isAdmin: false
  },

  goAdd: function() {
    wx.navigateTo({
      url: '/pages/admin/chemical/addChemical',
    })
  },

  adminSubmit: function (e) {
    var adminData = e.detail.value;
    if (adminData.password == "") {
      wx.showToast({
        title: '未填写密码',
        icon: 'none'
      })
    }
    else {
      var CryptoJS = require('../../../utils/aes.js')
      var key = CryptoJS.enc.Utf8.parse("aabbccddeeffgghh");
      var iv = CryptoJS.enc.Utf8.parse("aabbccddeeffgghh");
      adminData.password = CryptoJS.encrypt(adminData.password, key, iv);
      // console.log(adminData.password)
      var that = this;
      wx.request({
        url: 'https://chem.ufeng.top/whp/manager/login',
        method: 'post',
        header: {
          // 'content-type': 'application/x-www-form-urlencoded'
          'content-type': 'application/json'
        },
        data: adminData,
        success: function (res) {
          if(res.data.data){
            that.setData({
              isAdmin: true
            })
            wx.showToast({
              title: '登录成功',
            })
            console.log(res.data)
          }else{
            wx.showToast({
              title: '密码错误',
              icon: 'none',
              duration: 1500
            })
          }

        }
      });
    }
  },

  goAlarm: function(){
    wx.navigateTo({
      url: '/pages/admin/alarmList/alarmList',
    })
  }
})