import React from 'react';
import { Jumbotron, Button } from 'reactstrap';

const Example = (props) => {
  return (
    <div>
      <Jumbotron style={{padding:"50px 100px",fontFamily:'Microsoft YaHei',letterSpacing:"5px"}}>
        <h2 className="display-6">你好，欢迎光临本网站！</h2>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>本商城是*****，B2B交易平台，在线支付，仓储物流于一体的互联网科技公司。通过先进的B2B模式，有效解决传统IT分销渠道发展瓶颈，有效降低企业运营成本。公司紧跟移动互联网，围绕推动互联网IT产品创新，聚焦行业云端服务深度，协助行业参与方推进以智能化、云端化、安全性为特点的科技平台战略目标的实施。依托渠道和资源优势，打造国内最具特色的互联网科技平台。</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>WO256渠道商城是山东二五六网络技术有限公司旗下网站，集网络媒体、 B2B交易平台、在线支付、仓储于一体。 目前，已有注册会员5万多家。通过先进的B2B模式，有效的解决传统IT分销渠道发展瓶颈，有效降低企业运营成本。二五六将引领整个IT行业进入电子商务时代，构建中国IT渠道标准化的电子商务服务体系。</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>wo256渠道商城是服务于中国IT产品经销企业的开放式B2B在线交易与宣传推广的综合服务平台。通过完善与专业的宣传展示、订单交易、在线营销、货款管理、客户管理等模块，为IT产品经销企业打造完善专业化的渠道电子商务化服务体系。</p>
        <hr className="my-2" />
        <h4>我们的优势：</h4>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>1、八年渠道宣传运营经验，服务产品渠道代理商，积累了丰富的渠道经验及电商运营策略</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>2、专注于渠道运营、渠道宣传推广、产品销售、市场营销</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>3、强大的服务精英团队，多对一综合运营服务（运营/编辑/设计/商务 ）,360°全程贴心服务，全方位为您解决所有渠道运作问题</p>
        <hr className="my-2" />
       <h4>我们的服务: </h4>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>1、渠道线上商铺服务；</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>2、渠道宣传推广服务；</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>3、电子商务化体系建设；</p>
        <p className="lead" style={{fontSize:"16px",lineHeight:"30px",textIndent:"34px"}}>4、电子商务化综合服务；</p>
        <hr className="my-2" />
      </Jumbotron>
    </div>
  );
};

export default Example;