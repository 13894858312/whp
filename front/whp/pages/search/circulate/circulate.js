// pages/search/circulate/circulate.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chemicalId: '',
    chemicalName: '',
    status: ['生产', '储存', '运输', '经营', '使用', '废弃'],
    statusSelected: 0,
    position: {
      longitude: '',
      latitude: ''
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      chemicalId: options.chemicalId,
      chemicalName: options.chemicalName
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

  statusChange: function (e) {
    this.setData({
      statusSelected: e.detail.value
    })
  },

  locate: function(){
    var that = this
    wx.chooseLocation({
      success: function (res) {
        that.setData({
          position: {
            longitude: res.longitude,
            latitude: res.latitude
          },
        })
      },
    })
  },

  circulateSubmit: function (e) {
    var circularData = e.detail.value
    circularData.position = circularData.position.replace(/\s+/g, '')
    // 未登录禁止提交
    var signature = wx.getStorageSync('signature');
    if (signature == '') {
      wx.showToast({
        title: '请先登录',
        icon: 'none'
      })
    }
    else if(circularData.bn == ""){
      wx.showToast({
        title: '未填写产品批号',
        icon: 'none'
      })
    }
    else if(circularData.enterprise == ""){
      wx.showToast({
        title: '未填写企业名称',
        icon: 'none'
      })
    }
    else if (circularData.position == "" || circularData.position == ",") {
      wx.showToast({
        title: '未填写位置信息',
        icon: 'none'
      })
    }
    else{
      circularData.chemicalId = this.data.chemicalId
      circularData.state = circularData.state + 1
      wx.request({
        url: 'http://121.40.243.225:8091/whp/transfer/add',
        method: 'post',
        header: {
          // 'content-type': 'application/x-www-form-urlencoded'
          'content-type': 'application/json',
          'signature' : signature
        },
        data: circularData,
        success: function (res) {
          if (res.data.code != 0) {
            wx.showToast({
              title: '提交失败',
              icon: 'none'
            })
          } else {
            wx.showToast({
              title: '提交成功',
              icon: 'none'
            })
          }
          console.log(res.data)
        }
      });
    }
  }
})