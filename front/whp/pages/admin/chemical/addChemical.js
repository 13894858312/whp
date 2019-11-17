// pages/admin/chemical/addChemical.js
Page({
  addChemical: function(e){
    var data = e.detail.value;
    if(data.cas == ''){
      wx.showToast({
        title: '请输入化学品CAS号',
        icon: 'none'
      })
    }
    else if(data.cnName == ''){
      wx.showToast({
        title: '请输入化学品中文名称',
        icon: 'none'
      })
    }
    else if(data.enName == ''){
      wx.showToast({
        title: '请输入化学品英文名称',
        icon: 'none'
      })
    }
    else if(data.formula == ''){
      wx.showToast({
        title: '请输入化学品分子式',
        icon: 'none'
      })
    }
    else if(data.weight == ''){
      wx.showToast({
        title: '请输入化学品分子量',
        icon :'none'
      })
    }
    else if(data.weight <= 0){
      wx.showToast({
        title: '分子量需大于0',
        icon :'none'
      })
    }
    else {
      wx.request({
        url: 'http://120.55.54.247:8090/chemical/addChemical',
        method: 'post',
        header: {
          'content-type': 'application/json'
        },
        data: data,
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
            setTimeout(function () {
              wx.redirectTo({
                url: '/pages/common/qrcode/qrcode?cas='+data.cas,
              })
            }, 1000)

          }
        },
        fail: function(res){
          console.log("添加化学品出错，错误信息：" + res);
        }
      })
    }
  }
})