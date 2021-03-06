//时间戳转时间
export function formatTime(time) {
    var unixtimestamp = new Date(parseInt(time));
    var year = 1900 + unixtimestamp.getYear();
    var month = "0" + (unixtimestamp.getMonth() + 1);
    var date = "0" + unixtimestamp.getDate();
    var hour = "0" + unixtimestamp.getHours();
    var minute = "0" + unixtimestamp.getMinutes();
    var second = "0" + unixtimestamp.getSeconds();
    return year + "-" + month.substring(month.length - 2, month.length) + "-" + date.substring(date.length - 2, date.length)
        + " " + hour.substring(hour.length - 2, hour.length) + ":"
        + minute.substring(minute.length - 2, minute.length) + ":"
        + second.substring(second.length - 2, second.length);
}

//判断是否已经登录
export function isLogined(callback, to) {
    let userInfo = localStorage.getItem('userinfo');
    if (userInfo) {
      let user = JSON.parse(userInfo);
      if (user && user.uid) {
        callback(user);
      }
    } else {
      to && to.props.history.push({ pathname: `/login`, state: {} });
    }
}