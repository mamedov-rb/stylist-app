import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import Faker from 'faker'


class AppHeader extends Component {
    render() {
        let authenticated = this.props.isAuthenticated;
        return (
            <div className='ui horizontal list'>
                <div className='item'>
                    <img className="ui mini circular image" src={Faker.internet.avatar()}/>
                    <div className="content">
                        <div className="ui sub header"><Link to="/">Home</Link></div>
                    </div>
                </div>
                <div className='item'>
                    <img className="ui mini circular image" src={Faker.internet.avatar()}/>
                    <div className="content">
                        <div className="ui sub header"><Link to="/blog">Blog</Link></div>
                    </div>
                </div>
                <div className='item'>
                    <img className="ui mini circular image" src={Faker.internet.avatar()}/>
                    <div className="content">
                        <div className="ui sub header"><Link to="/course">Course</Link></div>
                    </div>
                </div>
                {authenticated ?
                    <div className='item'>
                        <img className="ui mini circular image" src={Faker.internet.avatar()}/>
                        <div className="content">
                            <div className="ui sub header"><Link to="/users">Users</Link></div>
                        </div>
                    </div> : ''
                }
                <div className='item'>
                    <img className="ui mini circular image" src={Faker.internet.avatar()}/>
                    <div className="content">
                        <div className="ui sub header"><Link to="/login">{authenticated ? 'Logout' : 'Login'}</Link>
                        </div>
                    </div>
                </div>

            </div>
        )
    }
}

export default AppHeader
