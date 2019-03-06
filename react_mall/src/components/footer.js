import React,{Component} from 'react';


export default class Navigator extends Component{

  render() {
    return (
      <div style={{width:"100%",backgroundColor:"#eee", letterSpacing:"4px"}}>
      <div style={{width:"1000px",margin:"0 auto",textAlign:"center",padding:"20px"}}>
      <p style={{textAlign:"center"}}><a>关于我们</a><em>|</em><a>公司简介</a><em>|</em><a>诚聘英才</a><em>|</em><a>联系我们</a><em>|</em><a>政策法规</a></p>
      <p style={{textAlign:"center"}}>客服热线：400 865 4971| 工作日：8: 00-22: 00|节假日: 10: 00-17: 30</p>
      <p style={{textAlign:"center"}}>*****有限公司版权所有2012-2019 </p>
  </div>
      </div>
    );
  }
}