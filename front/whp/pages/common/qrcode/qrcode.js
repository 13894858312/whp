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
      url: 'https://chem.ufeng.top/whp/chemical/genQrCode',
      method: 'post',
      data: { cas: cas },
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        if (res.data.code != 0) {
          wx.showToast({
            title: '生成二维码失败',
            icon: 'none'
          })
        } else {
          that.setData({
            imageUrl: 'https://chem.ufeng.top'+res.data.data
          });
        }
      },
      fail: function (res) {
        console.log("生成二维码出错，错误信息：" + res);
      }
    })
  },

  saveQrCode: function(){
    var that = this;
    wx.showModal({
      title: '保存二维码？',
      success: function(){
        wx.downloadFile({
          url: that.data.imageUrl,
          success: function (res) {
            var imageFilePath = res.tempFilePath;
            if (imageFilePath != undefined) {
              wx.saveImageToPhotosAlbum({
                filePath: imageFilePath,
                success: function (data) {
                  wx.showToast({
                    title: "保存成功",
                  })
                }, fail: function (res) {
                  wx.showToast({
                    title: "保存失败",
                    icon: 'none'
                  })
                }
              })
            }
          },
        })
      }
    })
  }
})