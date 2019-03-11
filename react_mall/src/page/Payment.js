import React, { Component } from 'react';
import { connect } from 'react-redux';
import { productDetails, addToCart } from '../actions';
import { Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle } from 'reactstrap';
import { Input, Button } from 'antd';

const mapStateToProps = (state) => {
    return {
        rows: state.counter.lists.rows,
        total: state.counter.lists.total
    }
}
class Payment extends Component {
    componentDidMount() {
        var productId = this.props.match.params.id;
        this.props.productDetails({ productId });
    }

    addToCarts(product) {
        this.props.addToCart(product)
    }

    render() {
        // const {lists} = this.props;
        const { rows, total } = this.props;
        let data = {
            img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
            title: "飞利浦macbookpro转接口苹果电脑转换器typec拓展坞",
            price: 800.00,
            time: '2019-01-01',
            content: "众所周知一款车的外观对于一款，消费者所想要的是一款内外兼修的汽车",
        };
        return (
            <div>
                <Card style={{ width: "80%", margin: "40px auto", border: "1px solid #eee", fontFamily: 'Microsoft YaHei', overflow: "hidden", position: "relative", padding: "20px" }}>
                    <div style={{ display: 'flex', alignItems: 'center', padding: 10 }}>
                        <div>
                            <span style={{ color: '#3d3d3d', width: '100%' }}>{data.title}</span>
                            <div style={{ marginTop: 10 }}>
                                <img style={{ height: 50, width: 50, marginLeft: 10 }} src={data.img} />
                                <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, padding: '0 10px' }}>
                                    <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{data.price}元</span>
                                    <span style={{ backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px' }}>包邮</span>
                                    <span style={{ fontSize: 12, marginLeft: 30 }}>121人已付款</span>
                                </div>
                            </div>
                        </div>
                        <div style={{ flex: 1 }} />
                        <span type="danger" block onClick={() => this.routerTo()} style={{ width: 100, marginLeft: 50 }}>数量：1</span>
                    </div>
                    <div style={{ height: 3, backgroundColor: '#85A1D4', marginTop: 20 }} />
                    <div style={{display: 'flex', height: 50, alignItems: 'center'}}>
                        付款方式：<span style={{fontSize: 18, fontWeight: 700}}>支付宝</span>
                    </div>
                    <div style={{display: 'flex', height: 50, alignItems: 'center'}}>
                        付款密码：<Input.Password style={{width: 200}} placeholder="input password" />
                    </div>
                    <Button type="primary" style={{width: 100, marginTop: 20}}>确认付款</Button>
                </Card>
                <div style={{ minHeight: '60vh' }}></div>
            </div>

        )
    }
}

export default connect(mapStateToProps, { productDetails, addToCart })(Payment);
