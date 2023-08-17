import React from 'react';
import { Navbar, Nav, NavItem, NavLink, NavbarBrand, Button } from 'reactstrap';
import { Link } from 'react-router-dom';

function Menu() {
  return (
    <div>
    <Navbar color="light" light expand="md">
    <NavbarBrand href="/" color='blue'>Online Classroom</NavbarBrand>
      <Nav className="ml-auto" navbar>
        <NavItem>
          <NavLink href="/about/">About</NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="/courses/">Courses</NavLink>
        </NavItem>
      </Nav>
      <div className="header-buttons">
       <Link to="/login" style={{ fontWeight: 'bold' }}>
        <Button color="secondary">Sign-In</Button>
       </Link>
       <Link to="/register" style={{ fontWeight: 'bold' }}>
        <Button color="secondary" className="ml-2">Sign-Up</Button>
       </Link>
      </div>
    </Navbar>
    </div>
  );
}

export default Menu;
