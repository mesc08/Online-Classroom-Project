import React, { useState } from 'react';
import { Button, Container, Form, FormGroup, Label, Input, Card, CardBody, Row} from 'reactstrap';
import Menu from './Menu';

function Register(){
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [firstname, setFirstName] = useState('');
    const [username, setUserName] = useState('');
    const [confirmpassword, setConfirmPassword] = useState('');
    const [lastname, setLastName] = useState('');

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };
    
    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };
    
    const handleConfirmPasswordChange = (e) => {
        setConfirmPassword(e.target.value);
    };

    const handleFirstnameChange = (e) => {
      setFirstName(e.target.value);  
    };

    const handleUserNameChange = (e) => {
        setUserName(e.target.value);
    };

    const handleLastnameChange = (e) => {
        setLastName(e.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle login logic here (e.g., API call, authentication)
        console.log('register ',firstname, lastname, email, password, confirmpassword, username);
        setEmail('');
        setPassword('');
        setConfirmPassword('');
        setUserName('');
        setLastName('');
        setFirstName('');
    };
    return (
        <div>
        <Menu />
        <Container className="d-flex justify-content-center align-items-center h-100">
         <Card  className="p-5">
           <CardBody>
           <Row className="justify-content-center">
          <h2 className="text-center">Register</h2>
            <Form onSubmit={handleSubmit}>
                <FormGroup>
                    <Label for="email">Email</Label>
                    <Input
                        type="email"                        
                        id="email"
                        value={email}
                        onChange={handleEmailChange}
                        placeholder="Enter your email"
                        required
                    />
                </FormGroup>
                <FormGroup>
                <Label for="password">Password</Label>
                <Input
                    type="password"
                    id="password"
                    value={password}
                    onChange={handlePasswordChange}
                    placeholder="Enter your password"
                    required
                />
                </FormGroup>
                <FormGroup>
                <Label for="confirmpassword">Confirm Password</Label>
                <Input
                    type="password"
                    id="confirmpassword"
                    value={confirmpassword}
                    onChange={handleConfirmPasswordChange}
                    placeholder="Enter your confirm-password"
                    required
                />
                </FormGroup>
                <FormGroup>
                <Label for="username">UserName</Label>
                <Input
                    type="text"
                    id="username"
                    value={username}
                    onChange={handleUserNameChange}
                    placeholder="Enter your username"
                    required
                />
                </FormGroup>
                <FormGroup>
                <Label for="firstname">First Name</Label>
                <Input
                    type="text"
                    id="firstname"
                    value={firstname}
                    onChange={handleFirstnameChange}
                    placeholder="Enter your firstname"
                    required
                />
                </FormGroup>
                <FormGroup>
                <Label for="lastname">Last Name</Label>
                <Input
                    type="text"
                    id="lastname"
                    value={lastname}
                    onChange={handleLastnameChange}
                    placeholder="Enter your lastname"
                    required
                />
                </FormGroup>
                <Button color='primary' block  type='submit'>Register</Button>
            </Form>
          </Row>
            </CardBody>
        </Card>
        </Container>
        </div>
    );
}

export default Register;
