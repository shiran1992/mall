import React, { Component } from 'react';
import { connect } from 'react-redux';
import { UncontrolledCarousel, Card, CardImg } from 'reactstrap';
import { NavLink } from 'react-router-dom';
import { Button } from 'antd';


const mapStateToProps = (state) => {
  return {
    carts: state.carts,
  }
}

class CarList extends Component {
  constructor(props) {
    super(props);
    this.state = { value: [] };
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    if (event.target.value == -1) {
      if (event.target.checked == true) {
        let items = this.state.value;
        items = [];
        var arr = this.props.carts;
        for (var i = 0; i < arr.length; i++) {
          var arrId = arr[i].checked;
          this.setState({ arrId: true });
          items.push('' + arr[i].id + '')
        }

        this.setState({ value: items });
      } else {

      }

    } else {
      let item = event.target.value;
      let items = this.state.value.slice();

      let index = items.indexOf(item);
      index === -1 ? items.push(item) : items.splice(index, 1);
      this.setState({ value: items });
      console.log(items);
    }
  }


  showInput = (e) => {//全选和全不全
    console.log(e.target.checked);
    this.setState({
      check: e.target.checked,
      checks: e.target.checked,
    })
  }

  //商品列表
  renderShopList() {

    var lst = [
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
    var lstlen = lst.length;
    var jsx = [];
    for (let i = 0; i < lstlen; i++) {
      jsx.push(
        <Card style={{ width: "80%", height: 150, margin: 12, border: "1px solid #ccc", float: 'left', fontFamily: 'Microsoft YaHei' }}
          key={i} onClick={() => {
            this.routerTo();
          }}>
          <div style={{ display: 'flex', alignItems: 'center', padding: 10 }}>
            <div>
              <span style={{ color: '#3d3d3d', width: '100%' }}>{lst[i].title}</span>
              <div style={{ marginTop: 10 }}>
                <img style={{ height: 50, width: 50, marginLeft: 10 }} src={lst[i].img} />
                <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, padding: '0 10px' }}>
                  <span style={{ color: '#F40', fontWeight: 700, fontFamily: 'arial' }}>单价：{lst[i].price}元</span>
                  <span style={{ backgroundColor: '#F40', color: 'white', fontSize: 12, marginLeft: 10, padding: '0 5px' }}>包邮</span>
                  <span style={{ fontSize: 12, marginLeft: 30 }}>121人已付款</span>
                </div>
              </div>
            </div>
            <div style={{ flex: 1 }} />
            <Button type="danger" block onClick={() => this.routerTo()} style={{ width: 100, marginLeft: 50 }}>去付款</Button>
          </div>
        </Card>
      );
    }
    return jsx;

  }

  render() {
    return (
      <div style={{ display: 'flex', width: 1200, flexDirection: 'column', margin: '0 auto', minHeight: '100vh' }}>
        {this.renderShopList()}
      </div>
    )
  }

  //点击付款
  routerTo(id) {
    this.props.history.push({ pathname: '/pay/' + id, state: {} });
  }
}

export default connect(mapStateToProps)(CarList);