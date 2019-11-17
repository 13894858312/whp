// pages/admin/qrcode/qrcode.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imageUrl : undefined
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var cas = options.cas;
    wx.request({
      url: 'http://120.55.54.247:8090/chemical/genQrCode',
      method: 'post',
      data: { cas: cas },
      header: {
        'content-type': 'application/json'
      },
      success: function (qrres) {
        if (qrres.data.code != 0) {
          wx.showToast({
            title: '生成二维码失败',
            icon: 'none'
          })
        } else {
          that.setData({
            imageUrl: 'http://120.55.54.247:8090/'+qrres.data.data
          });
        }
      },
      fail: function (qrres) {
        console.log("生成二维码出错，错误信息：" + qrres);
      }
    })
  },

  saveQrCode: function(){
    wx.saveImageToPhotosAlbum({
      filePath: 'http://120.55.54.247:8090/' + qrres.data.data,
    })
  }
})