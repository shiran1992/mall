// 入口文件
import React from 'react';
import ReactDOM from 'react-dom'
import { connect } from 'react-redux'
import { increase,decrease } from '../actions'

const mapStateToProps = (state)=>{
    return {
        count : state.counter.count,
        count1: state.counter.count1,
    }
}

class Counter extends React.Component{

    render(){
        const {count,count1,increase,decrease} = this.props;
        return (
           <div>
            Count: {count}
            <hr/>
            Count1: {count1}
            <br/>
            <button onClick={increase}>count++</button>
            <button onClick={decrease}>count1--</button>

           </div>
        )
    }
}

export default connect(mapStateToProps,{increase,decrease})(Counter);
