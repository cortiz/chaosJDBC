# ChaosJDBC: Testing Transactional Code with Random Failures

## Overview

ChaosJDBC is an open-source Java project designed for testing transactional code in JDBC applications. 

It provides a passthrough JDBC driver that introduces random failures or deterministic behavior, allowing developers to simulate real-world scenarios and evaluate the robustness of their transactional code.

## Features

- **Random Failures**: Injects random failures into JDBC interactions to test how your application handles unexpected issues.
- **Deterministic Mode**: Allows you to configure deterministic failure scenarios for precise testing.
- **JDK Matrix Support**: Built-in support for multiple JDK versions (8, 17, 21) to ensure compatibility.
- **Artifact Release with Classifiers**: Easily release artifacts for different JDK versions with classifiers.

## Getting Started

To integrate ChaosJDBC into your project, follow these steps:

1. Clone the repository: `git clone https://github.com/cortiz/chaosJDBC.git`
2. Build the project using Maven: `mvn clean install`
3. Configure ChaosJDBC in your JDBC applications and start testing.

For detailed usage instructions, refer to the [Documentation](https://github.com/cortiz/chaosJDBC/wiki).

## Contributing

We welcome contributions! If you'd like to contribute to ChaosJDBC, please check out our [Contribution Guidelines](https://github.com/cortiz/chaosJDBC/blob/main/CONTRIBUTING.md).

## License

ChaosJDBC is licensed under the [BSD 3-Clause License](https://opensource.org/licenses/BSD-3-Clause).

## Contact

- **Maintainer**: [Carlos Ortiz](https://github.com/cortiz)
- **Issue Tracker**: [GitHub Issues](https://github.com/cortiz/chaosJDBC/issues)
- **Discussion**: [GitHub Discussions](https://github.com/cortiz/chaosJDBC/discussions)

## Acknowledgments

We would like to express our gratitude to the open-source community and contributors who have helped make ChaosJDBC possible.
