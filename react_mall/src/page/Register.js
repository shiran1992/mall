import React, { Component } from 'react';
import { Row, Col, Menu, Icon, Button, Input } from 'antd';
import { Slider } from 'antd';


class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            phone: '',
            pwd: '',
            _pwd: ''
        };
    }

    onChangeUserName = (e) => {
        this.setState({ userName: e.target.value });
    }

    render() {
        const { phone, pwd, _pwd } = this.state;
        return (
            <div style={{ margin: "0 auto", overflow: "hidden" }}>
                <div id="header">
                    <div className="logo">
                        <h1>1111</h1>
                    </div>
                </div>
                <div id="content">
                    <div className="login-newbg register-newbg"></div>
                    <div className="content-layout">
                        <div className="login-box-warp">
                            <div className="login-title">注册</div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, width: 250, height: 50, }}>
                                <Input placeholder="手机号" value={phone} />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 10, width: 250, height: 50, }}>
                                <Input.Password placeholder="密码" />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 10, width: 250, height: 50, }}>
                                <Input.Password placeholder="确认密码" />
                            </div>
                            <div style={{ marginTop: 40 }}>
                                <Button type="primary" block>提交</Button>
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
}

export default Register; 