// pages/search/searchList/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    resultList: undefined,
    length: 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://120.55.54.247:8090/chemical/getChemicals',
      data: {cas: options.cas, name: options.name},
      method: 'post',
      success: function(res){
        if(res.data.code != 0){
          wx.showToast({
            title: '获取数据失败',
          })
        }else{
          that.setData({
            resultList: res.data.data,
            length: res.data.data.length
          })
        }
      },
      fail: function(err){
        console.log(err)
      }
    })
  },

  checkInfo: function(e){
    var id = e.currentTarget.dataset.id;
    wx.redirectTo({
      url: '/pages/search/detail/detail?chemicalId='+id,
    })
  }
})