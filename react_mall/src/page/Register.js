import React, { Component } from 'react';
import { message, Button, Input } from 'antd';
import API from "../utils/API";


class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            phone: '',
            pwd: '',
            _pwd: ''
        };
    }

    onChangePassword(e) {
        this.setState({ pwd: e.target.value });
    }

    onChangePassword1(e) {
        this.setState({ _pwd: e.target.value });
    }

    render() {
        const { phone, pwd, _pwd } = this.state;
        return (
            <div style={{ margin: "0 auto", overflow: "hidden" }}>
                <div id="header">
                    <div className="logo">
                        <h1>电脑配件城</h1>
                    </div>
                </div>
                <div id="content">
                    <div className="login-newbg register-newbg"></div>
                    <div className="content-layout">
                        <div className="login-box-warp">
                            <div className="login-title">注册</div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 10, width: 250,  }}>
                                <Input placeholder="手机号" ref={node => this.phone = node} />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, width: 250, }}>
                                <Input placeholder="昵称" ref={node => this.name = node} />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, width: 250, }}>
                                <Input.Password placeholder="密码" onChange={(e) => { this.onChangePassword(e); }} />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, width: 250, }}>
                                <Input.Password placeholder="确认密码" onChange={(e) => { this.onChangePassword1(e); }} />
                            </div>
                            <span className="small-text" style={{ float: "right", marginTop: 10}} onClick={() => { this.routerTo(); }}>
                                登录
                            </span>
                            <div style={{ marginTop: 30 }}>
                                <Button type="primary" block onClick={() => { this.onClickSubmit(); }}>提交</Button>
                            </div>
                        </div>

                    </div>
                </div>

                <div id="footer">
                    <div className="footer-bd">
                        <p style={{ textAlign: "center" }}>
                            <span>网络文化经营许可证：浙网文[2016]0132-032号</span>
                            <b>|</b>
                            <span>增值电信业务经营许可证：浙B2-20080224-1</span>
                            <b>|</b>
                            <span>信息网络传播视听节目许可证：1109364号</span>
                        </p>
                    </div>
                </div>
            </div>
        )
    }

    //点击登陸
    routerTo(v) {
        this.props.history.push({ pathname: `/login`, state: { data: v } });
    }

    async onClickSubmit() {
        if (!this.phone.state.value) {
            message.error("手机号码不可以为空哦~");
            return;
        }
        if (!this.name.state.value) {
            message.error("昵称不可以为空哦~");
            return;
        }
        if (!this.state.pwd || !this.state._pwd) {
            message.error("密码或确认密码不可以为空哦~");
            return;
        }
        if (this.state.pwd == this.state._pwd) {
            let data = await API("RegisterServlet", {
                phone: this.phone.state.value,
                name: this.name.state.value,
                password: this.state.pwd
            }, { method: "get" });
            if (data && data != "false") {
                console.log(data);
                this.routerTo();
            } else {
                message.error("此号码已注册！")
            }
        } else {
            message.error("密码和确认密码不相同~");
        }
    }
}

export default Register; 