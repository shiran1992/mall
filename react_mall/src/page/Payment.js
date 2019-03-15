import React, { Component } from 'react';
import { Input, Button, message } from 'antd';
import { Card, CardImg } from 'reactstrap';
import BaseConfig from "../config/BaseConfig";
import API from "../utils/API";

class Payment extends Component {
    constructor(props) {
        super(props);
        this.state = {
            pwd: "",
            shop: {}
        }
    }

    componentDidMount() {
        let sid = this.props.match.params.id;
        this.getShopInfo(sid)
    }

    //获取商品详情
    async getShopInfo(sid) {
        let shop = await API("GetShopBySidServlet", { sid: sid }, { method: "get" });
        if (shop) {
            this.setState({
                shop: shop
            });
        }
    }

    onChangePassword(e) {
        this.setState({ pwd: e.target.value });
    }

    render() {
        let data = this.state.shop;
        return (
            <div>
                <Card style={{ width: "80%", margin: "40px auto", border: "1px solid #eee", fontFamily: 'Microsoft YaHei', overflow: "hidden", position: "relative", padding: "20px" }}>
                    <div style={{ display: 'flex', alignItems: 'center', padding: 10 }}>
                        <div>
                            <span style={{ color: '#3d3d3d', width: '100%' }}>{data.title}</span>
                            <div style={{ marginTop: 10 }}>
                                <CardImg style={{ height: 50, width: 50, marginLeft: 10 }} src={BaseConfig.baseUrl + data.head} />
                                <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, padding: '0 10px' }}>
                                    <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{data.price}元</span>
                                    <span style={{ backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px' }}>包邮</span>
                                    <span style={{ fontSize: 12, marginLeft: 30 }}>{data.num}人已付款</span>
                                </div>
                            </div>
                        </div>
                        <div style={{ flex: 1 }} />
                        <span type="danger" block onClick={() => this.routerTo()} style={{ width: 100, marginLeft: 50 }}>数量：1</span>
                    </div>
                    <div style={{ height: 3, backgroundColor: '#85A1D4', marginTop: 20 }} />
                    <div style={{ display: 'flex', height: 50, alignItems: 'center' }}>
                        付款方式：<span style={{ fontSize: 18, fontWeight: 700 }}>支付宝</span>
                    </div>
                    <div style={{ display: 'flex', height: 50, alignItems: 'center' }}>
                        付款金额：<span style={{ fontSize: 18, fontWeight: 700, color: '#F40' }}>{data.price}元</span>
                    </div>
                    <div style={{ display: 'flex', height: 50, alignItems: 'center' }}>
                        收货地址：<span style={{ fontSize: 18, fontWeight: 700, color: '#F40' }}>{data.price}元</span>
                    </div>
                    <div style={{ display: 'flex', height: 50, alignItems: 'center' }}>
                        联系电话：<span style={{ fontSize: 18, fontWeight: 700, color: '#F40' }}>{data.price}元</span>
                    </div>
                    <div style={{ display: 'flex', height: 50, alignItems: 'center' }}>
                        付款密码：<Input.Password style={{ width: 200 }} placeholder="input password" onChange={(e) => { this.onChangePassword(e); }} />
                    </div>
                    <Button type="primary" style={{ width: 100, marginTop: 20 }} onClick={() => {
                        this.onClickPay();
                    }}>确认付款</Button>
                </Card>
                <div style={{ minHeight: '60vh' }}></div>
            </div>
        )
    }

    //确认付款
    onClickPay() {
        if (!this.state.pwd) {
            message.error("密码不可以为空哦~");
            return;
        }
        
        //API("CreateOrderServlet", { sid: sid }, { method: "get" })
    }
}

export default Payment;
