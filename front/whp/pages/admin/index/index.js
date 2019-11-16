// pages/admin/index/index.js
Page({
  goAdd: function() {
    wx.navigateTo({
      url: '/pages/admin/chemical/addChemical',
    })
  },

  goAlarm: function(){
    wx.navigateTo({
      url: '/pages/admin/alarmList/alarmList',
    })
  }
})