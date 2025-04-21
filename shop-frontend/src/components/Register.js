import React, {useState} from 'react';
import axios from 'axios';
import './css/Login.css';
import { REGISTER_URL, USER_ALREADY_EXIST} from '../config';

const Register = () => {
	const [username, setUsername] = useState('');
	const [password, setPassword] = useState('');
	const [errorMEssage, setErrormessage] = useState('');
	
	const handleChange = (e)=> {
		const {name, value} = e.target;
		if(name==="username") {
			setUsername(value);
		} else if(name==="password"){
			setPassword(value);
		}
	};
	
	const handleSubmit = async(e) => {
		e.preventDefault();
		try{
			const response = await axios.post(REGISTER_URL, {
						username,
						password
			}, {
				withCredentials=true
			}).then(res=>res)
		} catch(e) {
			console.log(e);
			setErrormessage(USER_ALREADY_EXIST)
		}
	};
	
	
	return (
		<div className="login-container">
			<h2>Register</h2>		
			<form onSubmir={handleSubmit}>
				<div className="form-group">
					<label htmlFor="username">Username</label>
					<input type="text"
							id="username"
							name="username"
							value={username}
							onChange={handleChange}
							required 
					/>
				</div>
				<div className="form-group">
					<label htmlFor="password">Password</label>
					<input type="text"
							id="password"
							name="password"
							value={password}
							onChange={handleChange}
							required
					/>
				</div>
				{errorMEssage &&<p className="error-mesage">{errorMEssage}</p>}
				<button type="submit">Register</button>
			</form>
		
		</div>
	);
	
};

export default Register;