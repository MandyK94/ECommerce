import React, {useState} from 'react';
import axios from 'axios';
import { LOGIN_URL, INVALID_LOGIN_ERROR_MESSAGE} from '../config';

const Login =() => {
	const [username, setUsername] = useState('');
	const [password, setPassword] = useState('');
	const [errorMessage, setErrorMessage] = useState('');
	
	// handle form submission
	
	const handleSubmit = async(e) => {
		e.preventDefault();
		//setErrorMessage('');
		
		try{
			console.log(LOGIN_URL);
			const response = await axios.post(LOGIN_URL, {
					username, 
					password
				}, {
					withCredentials:'true'
				}).then(res=>console.log(res));
				
			// store token in local storage
			localStorage.setItem('token', response.data.token);
			// redirect the page
			window.location.href = '/productList';
		} catch(error) {
			console.log(error);
			setErrorMessage(INVALID_LOGIN_ERROR_MESSAGE);
		}
	};
	
	const handleChange = (e) => {
		const {name, value} = e.target;
		if(name==='username') {
			setUsername(value);
		} else if(name==='password') {
			setPassword(value);
		}
	};
	
	return (
		<div className="login-container">
			<h2>Login</h2>
			<form onSubmit={handleSubmit}>
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
				{errorMessage && <p className="error-message">{errorMessage}</p>}
				<button type="submit">Login</button>
			</form>
		</div>
	);
};

export default Login;