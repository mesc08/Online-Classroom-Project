import React, { useState } from 'react';
import { Button, Container, Form, FormGroup, Label, Input, Card, CardBody, Row } from 'reactstrap';
import Menu from './Menu';

function Login(){
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    
    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };
    
    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };
    
    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle login logic here (e.g., API call, authentication)
        console.log('Login clicked with email:', email, 'and password:', password);
        setEmail('');
        setPassword('');
    };
    return (
        <div>
        <Menu />
        <Container className="d-flex justify-content-center align-items-center h-100">
         <Card  className="p-5">
           <CardBody>
           <Row className="justify-content-center">
          <h2 className="text-center">Login</h2>
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
                <Button color='primary' block  type='submit'>Login</Button>
            </Form>
          </Row>
            </CardBody>
        </Card>
        </Container>
        </div>
    );
}

export default Login;
