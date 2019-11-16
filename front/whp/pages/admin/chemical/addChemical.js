// pages/admin/chemical/addChemical.js
Page({
  addChemical: function(e){
    var data = e.detail.value;
    if(data.cas == ''){
      wx.showToast({
        title: '请输入化学品CAS号',
        icon: 'none'
      })
      return;
    }
    if(data.cnName == ''){
      wx.showToast({
        title: '请输入化学品中文名称',
        icon: 'none'
      })
      return;
    }
  
  }
})