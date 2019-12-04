import React, { Component } from 'react'

class AddProject extends Component {

  state = {
    projectName: "",
    projectIdentifier: "",
    projectDescription: "",
    end_date: "",
    start_date: ""
  }

  onChange = e =>{    
    this.setState({...this.state, [e.target.name]: e.target.value});
  }

  onSubmit = e => {
    e.preventDefault();
    const newProject = {...this.state }
    console.log(newProject)
  }

  render() {
    return (
      <div className="project">
      <div className="container">
          <div className="row">
              <div className="col-md-8 m-auto">
                  <h5 className="display-4 text-center">Create Project form</h5>
                  <hr />
                  <form onSubmit={this.onSubmit}>
                      <div className="form-group">
                          <input type="text" className="form-control form-control-lg" name="projectName" value={ this.state.projectName } placeholder="Project Name" onChange={this.onChange}/>
                      </div>
                      <div className="form-group">
                          <input type="text" className="form-control form-control-lg" name="projectIdentifier" 
                          value={this.state.projectIdentifier}
                          placeholder="Unique Project ID" onChange={this.onChange} />
                      </div>
                      
                      <div className="form-group">
                          <textarea className="form-control form-control-lg" name="projectDescription" 
                          value={this.state.projectDescription}
                          placeholder="Project Description" onChange={this.onChange} ></textarea>
                      </div>
                      <h6>Start Date</h6>
                      <div className="form-group">
                          <input type="date" className="form-control form-control-lg" name="start_date" value={this.state.start_date} onChange={this.onChange} />
                      </div>
                      <h6>Estimated End Date</h6>
                      <div className="form-group">
                          <input type="date" className="form-control form-control-lg" name="end_date" value={this.state.end_date} onChange={this.onChange} />
                      </div>

                      <input type="submit" className="btn btn-primary btn-block mt-4" />
                  </form>
              </div>
          </div>
      </div>
  </div>
    )
  }
}

export default AddProject;
