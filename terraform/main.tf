provider "aws" {
  region = "eu-central-1"
}

variable "http_port" {
  description = "HTTP port"
}

variable "server_port" {

}

output "number of instances in launch configuration" {
  value = "${aws_launch_configuration.example.count}"
}

resource "aws_launch_configuration" "example" {
  image_id = "ami-026d3b3672c6e7b66"
  instance_type = "t2.micro"
  security_groups = ["${aws_security_group.instance.id}"]
  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_security_group" "instance" {
  name = "terraform-example-instance"
  ingress {
    from_port = "${var.http_port}"
    to_port = "${var.http_port}"
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_autoscaling_group" "example" {
  launch_configuration = "${aws_launch_configuration.example.id}"
  availability_zones = ["${data.aws_availability_zones.all.names}"]
  max_size = 1
  min_size = 0
  tag {
    key = "Name"
    propagate_at_launch = true
    value = "terraform-asg-example"
  }
}

data "aws_availability_zones" "all" {}

resource "aws_elb" "example" {
  name = "terraform-asg-example"
  availability_zones = ["${aws_autoscaling_group.example.availability_zones}"]
  listener {
    instance_port = "${var.server_port}"
    instance_protocol = "http"
    lb_port = 80
    lb_protocol = "http"
  }
}
