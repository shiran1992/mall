import React,{Component} from 'react';
import {connect } from 'react-redux';
import { Table,Input } from 'reactstrap';
import { NavLink} from 'react-router-dom';


const mapStateToProps = (state)=>{
  return {
      carts: state.carts,
  }
}



 class Carts extends Component{


  constructor(props) {
    super(props);
    this.state        = {value: []};
    this.handleChange = this.handleChange.bind(this);
}
handleChange(event) {
  // ------------------------------------------未完成-----------
  // console.log(event.target.value);
  if(event.target.value==-1){
    if(event.target.checked==true){
    let items = this.state.value;
        items = [];
    var arr   = this.props.carts;
    for(var i=0;i<arr.length;i++){
      var arrId = arr[i].checked;
      this.setState({arrId: true});
      items.push(''+arr[i].id+'')
    }

  this.setState({value: items});

  // console.log(this.props.carts);
  console.log(items);

    }else{

    }

  }else{
    let item  = event.target.value;
    let items = this.state.value.slice();

    let index = items.indexOf(item);
    index === -1 ? items.push(item): items.splice(index, 1);
    this.setState({value: items});
  console.log(items);
  }



}


  showInput=(e)=>{//全选和全不全
    console.log(e.target.checked);
      this.setState({
        check : e.target.checked,
        checks: e.target.checked,
      })
  }




   showCarts = ()=>{
    var jsx        = [];
    var amount     = 0;
    var totalprice = 0;
    this.props.carts.map((item,index)=>{
      amount     += item.quantity;
      totalprice += item.price*item.quantity;
      jsx.push(
        <tr key={index}>
            <th><Input  type="checkbox" checked={true} onChange={this.handleChange} value={item.id}/></th>
            <th scope="row">{item.title}</th>
            <td>{item.quantity}</td>
            <td>{item.price}</td>
            <td>{item.price*item.quantity}</td>
        </tr>
      )
    })
    jsx.push(
      <tr key={jsx.length}>
            <td>商品总数：{amount}</td>
            <td>总计：{totalprice}</td>
            <td><NavLink to="/Counter">我的主页</NavLink></td>
            <td><NavLink to="/">继续购物</NavLink></td>
      </tr>
    )
    return jsx;
   }
  render(){
    return (
      <div>
        Carts
        <hr/>
        <Table hover style={{width:"1000px",margin:"20px auto"}}>
        <thead>
          <tr>
          <th><Input  type="checkbox" checked={true} onChange={this.showInput} value="-1"/>全选</th>
            <th style={{width:"50%",overflow:"hidden"}}>商品名称</th>
            <th>购买数量</th>
            <th>单价</th>
            <th>合计</th>
          </tr>
        </thead>
        <tbody>
        {this.showCarts()}
        </tbody>
        </Table>
      </div>
    )
  }
}

export default connect(mapStateToProps)(Carts);