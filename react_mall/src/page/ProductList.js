import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchList, addToCart } from '../actions'
import { NavLink } from 'react-router-dom';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';
const mapStateToProps = (state) => {
    return {
        rows: state.counter.lists.rows,
        total: state.counter.lists.total
    }
}


class ProductList extends Component {

    componentDidMount() {
        this.props.fetchList();
    }
    changePages = (page) => {
        this.props.fetchList({ page })
    }

    showPages() {
        var pages = Math.ceil(this.props.total / 20);
        var jsx = [];
        for (let i = 1; i <= pages; i++) {
            jsx.push(
                <li className="page-item" key={i} onClick={() => this.changePages(i)}><a className="page-link" href="javascript:void(0)">{i}</a></li>
            )
        }
        return jsx;
    }

    addToCarts = (product) => {
        this.props.addToCart(product)
    }

    showShopList() {
        let rows = [
            {
                img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
                title: "飞利浦macbookpro转接口苹果电脑转换器typec拓展坞",
                price: 800.00,
                content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
            },
            {
                img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
                title: "飞利浦macbookpro转接口苹果电脑转换器typec ",
                price: 800.00,
                content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
            },
            {
                img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
                title: "飞利浦macbookpro ",
                price: 800.00,
                content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
            },
            {
                img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
                title: "飞利浦macbookpro ",
                price: 800.00,
                content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
            },
            {
                img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
                title: "飞利浦macbookpro ",
                price: 800.00,
                content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
            },
            {
                img: "https://img1.360buyimg.com/pop/jfs/t1/10125/1/9402/107191/5c419222E3b8b26dd/e7994eb9583e6166.jpg",
                title: "飞利浦macbookpro ",
                price: 800.00,
                content: "众所周知一款车的外观对于一款车的销量的影响是何其的重要。但是，在今天竞争如此激烈的汽车市场上仅仅只是有出色的外观是不够的，消费者所想要的是一款内外兼修的汽车",
            }
        ];
        if (rows.length > 0) {
            var jsx = [];
            rows.map((item, index) => {
                jsx.push(
                    <Card style={{ width: "23%", height: "350px", margin: "12px", border: "1px solid #ccc", float: 'left', fontFamily: 'Microsoft YaHei', cursor: 'pointer' }}
                        key={index} onClick={() => {
                            this.routerTo();
                        }}>
                        <CardImg top style={{ width: '100%' }} src={item.img} />
                        <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, padding: '0 10px' }}>
                            <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{item.price}元</span>
                            <span style={{ backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px' }}>包邮</span>
                            <div style={{ flex: 1 }} />
                            <span style={{ fontSize: 12 }}>121人已付款</span>
                        </div>
                        <span style={{ color: '#3d3d3d', width: '100%', padding: 10 }}>{item.title}</span>
                    </Card>
                )
            })
            return jsx;
        } else {
            return null;
        }
    }

    render() {
        //const { rows, total } = this.props;
        let rows = [1, 2, 3, 4, 5, 6, 7, 8, 91, 2, 3, 4, 5, 5];
        return (
            <div>
                <nav aria-label="Page navigation example" style={{ width: "1170px", margin: "0 auto" }}>
                    <ul className="pagination">
                        {this.showPages()}
                    </ul>
                </nav>
                <div style={{ width: "1200px", margin: "0 auto", overflow: "hidden" }}>
                    {this.showShopList(rows)}
                </div>
                <nav aria-label="Page navigation example" style={{ width: "1170px", margin: "0 auto" }}>
                    <ul className="pagination">
                        {this.showPages()}
                    </ul>
                </nav>
            </div>
        )
    }

    //点击商品
    routerTo(id) {
        this.props.history.push({ pathname: '/product/' + id, state: {} });
    }

}
export default connect(mapStateToProps, { fetchList, addToCart })(ProductList);