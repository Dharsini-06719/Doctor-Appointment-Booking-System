import java.util.*;

public class QuestionsRepository {
    public static List<TopicModule> buildModules() {
        List<TopicModule> modules = new ArrayList<>();

        TopicModule week1 = new TopicModule("Information Security Fundamentals");
        week1.add(new Question(
                "How do spear-phishing attacks differ from general phishing attacks?",
                new String[]{
                        "They use only phone calls as a medium",
                        "They are randomly sent to thousands of people",
                        "They target specific individuals with personalized messages",
                        "They do not involve malware at all"
                }, 3, 3, week1.title
        ));
        week1.add(new Question(
                "What does ransomware typically do to a victim’s files?",
                new String[]{
                        "Deletes them permanently",
                        "Encrypts them to prevent access",
                        "Transfers them to another device",
                        "Makes them publicly available online"
                }, 2, 4, week1.title
        ));
        week1.add(new Question(
                "Which of the following are examples of systems protected under Critical Infrastructure Protection (CIP)?",
                new String[]{
                        "Gaming consoles and home Wi-Fi routers",
                        "SCADA systems, Industrial Control Systems (ICS), and operational technology",
                        "Social media networks and entertainment apps",
                        "Educational platforms and student databases"
                }, 2, 5, week1.title
        ));
        week1.add(new Question(
                "_______________ is the protection of information assets that use, store, or transmit information through the application of policy, education, and technology.",
                new String[]{
                        "Network Security",
                        "Operations Security",
                        "Communications Security",
                        "Information Security"
                }, 4, 2, week1.title
        ));
        week1.add(new Question(
                "_______ is the property of information that describes how data is whole, complete, and uncorrupted.",
                new String[]{
                        "Integrity",
                        "Availability",
                        "Confidentiality",
                        "Accuracy"
                }, 1, 1, week1.title
        ));
        week1.add(new Question(
                "To protect the confidentiality of information, which of the following measures can be taken:",
                new String[]{
                        "Information classification",
                        "Secure document storage",
                        "Application of general security policies",
                        "All the above"
                }, 4, 3, week1.title
        ));
        week1.add(new Question(
                "In the context of cybersecurity, how can technology act as a source of threat?",
                new String[]{
                        "It includes tools that can attack other networks",
                        "It increases internet traffic for organizations",
                        "It automates routine business operations",
                        "Through software that prevents users from sharing information"
                }, 1, 4, week1.title
        ));
        week1.add(new Question(
                "True or False: Information Security is not a process, but a product or a technology.",
                new String[]{
                        "True",
                        "False",
                        "", ""
                }, 2, 1, week1.title
        ));
        week1.add(new Question(
                "___________ is a manipulation technique that exploits human error to gain private information, access, or valuables",
                new String[]{
                        "Session Hijacking",
                        "Salting",
                        "Social Engineering",
                        "Smurf Attack"
                }, 3, 2, week1.title
        ));
        week1.add(new Question(
                "Which of the following scenarios represents a breach involving protected health information (PHI)?",
                new String[]{
                        "Sharing a patient’s prescription history along with their name",
                        "Forwarding anonymous health statistics to a research team",
                        "Posting a hospital’s general policy on patient intake",
                        "Transmitting appointment schedules without personal details"
                }, 1, 5, week1.title
        ));
        modules.add(week1);

        TopicModule week2 = new TopicModule("Network & Security Management");
        week2.add(new Question(
                "What is the primary purpose of the McCumber Cube?",
                new String[]{
                        "To develop network security protocols",
                        "To create operating systems",
                        "To establish and evaluate information security programs",
                        "To analyze network traffic performance"
                }, 3, 3, week2.title
        ));
        week2.add(new Question(
                "Consider the following statements\n" +
                        "a. The first dimension of the McCumber cube identifies the goals to protect the cyber world.\n" +
                        "b. The second dimension of the McCumber cube focuses on the problems of protecting all of the states of data in the cyber world. \n" +
                        "c. The third dimension of the McCumber cube defines the types of controls used to protect the cyber world.\n" +
                        "Which of the above statements are True?",
                new String[]{
                        "Only a is true",
                        "a and b are true",
                        "b and c are true",
                        "a,b,and c are true"
                }, 4, 4, week2.title
        ));
        week2.add(new Question(
                "In a malware detection system, when legitimate business software is incorrectly identified as malicious, this represents:",
                new String[]{
                        "True Positive (TP)",
                        "False Positive (FP)",
                        "True Negative (TN)",
                        "False Negative (FN)"
                }, 2, 3, week2.title
        ));
        week2.add(new Question(
                "True or False: A False Negative in malware detection means the system correctly identifies a safe file as non-malicious.",
                new String[]{"True", "False", "", ""}, 2, 2, week2.title
        ));
        week2.add(new Question(
                "A vulnerability in cybersecurity is best defined as:",
                new String[]{
                        "A malicious program designed to damage systems",
                        "A security patch released by software vendors",
                        "A method used by attackers to gain unauthorized access",
                        "A weakness or flaw in technology, processes, or human behavior that leaves systems open to exploitation"
                }, 4, 3, week2.title
        ));
        week2.add(new Question(
                "An exploit is primarily:",
                new String[]{
                        "A weakness in system security that needs patching",
                        "A technique used to compromise a system",
                        "A novel self-protecting antivirus software",
                        "A security framework for risk assessment"
                }, 2, 3, week2.title
        ));
        week2.add(new Question(
                "True or False: Accuracy is an attribute of information that describes how data is genuine or original rather than reproduced or fabricated.",
                new String[]{"True", "False", "", ""}, 2, 2, week2.title
        ));
        week2.add(new Question(
                "What is a recommended defense against phishing emails?",
                new String[]{
                        "Always open attachments to check content",
                        "Click links only if the sender is familiar",
                        "Verify the source and avoid clicking suspicious links",
                        "Forward the email to colleagues"
                }, 3, 3, week2.title
        ));
        week2.add(new Question(
                "Which of the following is not a good practice for balancing information security and access?",
                new String[]{
                        "Regular review of user access rights",
                        "Implementing role-based access control",
                        "Granting blanket access to all employees",
                        "Monitoring and auditing access logs"
                }, 3, 4, week2.title
        ));
        week2.add(new Question(
                "In an information system, which component is responsible for enabling communication and data transfer between devices?",
                new String[]{"Hardware", "Software", "Networks", "Data"}, 3, 2, week2.title
        ));
        modules.add(week2);

        TopicModule week3 = new TopicModule("Governance, Risk, and Compliance (GRC) in Cybersecurity");

        week3.add(new Question(
                "A company’s risk register lists “third-party data breach” as a critical risk. Which GRC function is primarily responsible for ensuring ongoing monitoring and mitigation of this risk?",
                new String[]{"Governance", "Reducible Breach", "Compliance", "Risk Management"},
                4, 3, week3.title
        ));

        week3.add(new Question(
                "Which of the following statements is correct regarding the implementation of a GRC framework?",
                new String[]{
                        "Implementing a GRC framework guarantees that an organization has immunity from all cyber threats.",
                        "A GRC framework helps organizations identify, assess, and mitigate cyber risks, but does not make them fully immune to threats.",
                        "GRC frameworks are only relevant for financial compliance and do not address cybersecurity.",
                        "GRC frameworks eliminate the need for cybersecurity controls."
                },
                2, 4, week3.title
        ));

        week3.add(new Question(
                "True or False: de facto standard refers to instructions that dictate certain standard behavior within an organization.",
                new String[]{"True", "False", "", ""}, 2, 2, week3.title
        ));

        week3.add(new Question(
                "Which of the following refers to a detailed statement of what must be done to comply with policy?",
                new String[]{"de jure practices", "guidelines", "standard", "procedures"},
                3, 3, week3.title
        ));

        week3.add(new Question(
                "If an organization’s policy states “All confidential data must be protected,” which of the following would be the most appropriate standard to support this policy?",
                new String[]{
                        "Employees should consider using strong passwords",
                        "Confidential data must be encrypted using AES-256",
                        "Steps for reporting a data breach",
                        "Encouraging staff to attend security training"
                },
                2, 4, week3.title
        ));

        week3.add(new Question(
                "True or False: Compliance activities in a GRC framework are limited to following internal company policies and do not involve external laws or regulations.",
                new String[]{"True", "False", "", ""}, 2, 2, week3.title
        ));

        week3.add(new Question(
                "MSQ: Which of the following is not an example of preventive controls in IT security?",
                new String[]{
                        "Firewall configuration blocking unauthorized ports",
                        "Security awareness training for employees",
                        "Daily review of audit logs",
                        "Multi-factor authentication (MFA) for system access",
                        "Data backup and recovery solutions"
                },
                3, 4, week3.title
        ));

        week3.add(new Question(
                "Which framework, developed by the IT community, prioritizes IT control objectives and is specified by ISACA (Information Systems Audit and Control Association)?",
                new String[]{"COBIT", "COSO", "ISO/IEC 27001", "NIST Cybersecurity Framework"},
                1, 3, week3.title
        ));

        week3.add(new Question(
                "Which of the following statements about the NIST Cybersecurity Framework is correct?",
                new String[]{
                        "It guarantees complete protection against all cyber threats.",
                        "Only large organizations can benefit from it.",
                        "The framework is flexible and can be customized to fit an organization’s needs.",
                        "Implementing it is a one-time activity and does not require ongoing updates.",
                        "It deals only with technology and does not consider employee training or policies."
                },
                2, 4, week3.title
        ));

        week3.add(new Question(
                "Which of the following statements is correct regarding ISO 27001 certification?",
                new String[]{
                        "ISO 27001 certification is only relevant for government agencies.",
                        "ISO 27001 certification can be issued to both organizations and individuals.",
                        "ISO 27001 certification can only be issued to organizations.",
                        "ISO 27001 certification is only available to individuals, not organizations."
                },
                3, 3, week3.title
        ));
        modules.add(week3);

        TopicModule week4 = new TopicModule("Business Continuity and Disaster Recovery (BC/DR)");

        week4.add(new Question(
                "_______________ is the actions taken by management to specify the intermediate goals and objectives of the organization in order to obtain specified strategic goals, followed by estimates and schedules for the allocation of resources necessary to achieve those goals and objectives.",
                new String[]{"Tactical Planning", "Strategic Planning", "Operational Planning", "Business Continuity Planning"},
                1, 3, week4.title
        ));

        week4.add(new Question(
                "True or False: Strategic plans are used to create operational plans, which in turn are used to develop tactical plans.",
                new String[]{"True", "False", "", ""}, 2, 2, week4.title
        ));

        week4.add(new Question(
                "The actions taken by senior management to develop and implement a combined Disaster Recovery (DR) and Business Continuity (BC) policy, plan, and set of recovery teams is known as",
                new String[]{"Business Resumption Planning (BRP)", "Business Continuity Planning (BCP)", "Disaster Recovery Planning (DCP)", "Incident Response Planning (IRP)"},
                1, 3, week4.title
        ));

        week4.add(new Question(
                "_________ is an adverse event that could result in loss of an information asset or assets, but does not currently threaten the viability of the entire organization.",
                new String[]{"Disaster", "Phishing", "Incident", "Impact"},
                3, 2, week4.title
        ));

        week4.add(new Question(
                "Contingency Plan includes",
                new String[]{
                        "Incident Response Planning (IRP), Organizational Planning (OP), and Business Continuity Planning (BCP)",
                        "Organizational Planning (OP), Disaster Recovery Planning (DRP), and Business Continuity Planning (BCP)",
                        "Incident Response Planning (IRP), Disaster Recovery Planning (DRP), and Tactical Planning (TP)",
                        "Incident Response Planning (IRP), Disaster Recovery Planning (DRP), and Business Continuity Planning (BCP)"
                },
                4, 3, week4.title
        ));

        week4.add(new Question(
                "_________ is an investigation and assessment of adverse events that can affect the organization, conducted as a preliminary phase of the contingency planning process.",
                new String[]{"Business Contingency Plan", "Direct Changeover Conversion Strategy", "Crisis Management Planning", "Business Impact Analysis"},
                4, 3, week4.title
        ));

        week4.add(new Question(
                "_______ is the total amount of time the system owner is willing to accept for a mission/business process outage or disruption, including all impact considerations.",
                new String[]{"Recovery Time Objective", "Work Recovery Time", "Maximum Tolerable Downtime", "Total Recovery Time"},
                3, 3, week4.title
        ));

        week4.add(new Question(
                "The presence or execution of unknown programs or processes is a",
                new String[]{"Possible incident indicator", "Probable incident indicator", "Definite incident indicator", "All the above"},
                1, 2, week4.title
        ));

        week4.add(new Question(
                "An organization can choose from several cost-based strategies when planning for business continuity. _______is a facility that provides only basic services, with no computer hardware or peripherals.",
                new String[]{"Hot Sites", "Warm Sites", "Cold Sites", "Yellow Sites"},
                3, 3, week4.title
        ));

        week4.add(new Question(
                "Which of the following statements does not accurately distinguish between a threat and an attack in cybersecurity? (Select all that apply. More than one answer may be possible)",
                new String[]{
                        "A threat is a potential danger, while an attack is an active action taken to exploit that danger",
                        "An attack can exist without a preceding threat",
                        "A threat actor often carries out an attack",
                        "An attack's success always depends on the existence of a vulnerability that the threat agent can exploit"
                },
                2, 4, week4.title // multi-answer placeholder
        ));
        modules.add(week4);

        TopicModule week5 = new TopicModule("Information Security Policies and Cyber Hygiene");

        week5.add(new Question(
                "Which of the following statement is not true?",
                new String[]{
                        "Policies direct how issues should be addressed and technologies should be used.",
                        "Information security policy is best disseminated in a comprehensive security education, training, and awareness (SETA) program.",
                        "Policies are more detailed than standards and describe the steps that must be taken to conform to standards.",
                        "Management must use policies as the basis for all information security planning, design, and deployment."
                },
                3, 3, week5.title
        ));

        week5.add(new Question(
                "_______ is an organizational policy that provides detailed, targeted guidance to instruct all members of the organization in the use of a resource, such as one of its processes or technologies.",
                new String[]{
                        "Systems-specific security policy",
                        "Issue-specific security policy",
                        "Enterprise information security policy",
                        "General or security program policy"
                },
                2, 3, week5.title
        ));

        week5.add(new Question(
                "Which of the following is not a component of Enterprise information security policy?",
                new String[]{
                        "Statement of Purpose",
                        "Information Security Responsibilities and Roles",
                        "Reference to other Information Standards and Guidelines",
                        "Statement of Policy"
                },
                4, 2, week5.title
        ));

        week5.add(new Question(
                "________ contains the specifications of authorization that govern the rights and privileges of users to a particular information asset.",
                new String[]{
                        "Access Control List (ACL)",
                        "Capabilities Table",
                        "Configuration Rules",
                        "Authentication Protocol"
                },
                1, 3, week5.title
        ));

        week5.add(new Question(
                "Access Control Matrix combines the information in",
                new String[]{
                        "Access Control List (ACL)s and Capability Tables.",
                        "Access Control List (ACL)s and Authentication Protocol.",
                        "Authentication Protocol and Capability Tables.",
                        "Configuration Rules and Capability Tables."
                },
                1, 3, week5.title
        ));

        week5.add(new Question(
                "Which of the following best differentiates cyber hygiene from cybersecurity?",
                new String[]{
                        "Cyber hygiene is hardware-focused, while cybersecurity is software-focused.",
                        "Cyber hygiene is reactive in nature, while cybersecurity is always proactive.",
                        "Cyber hygiene involves routine practices for maintaining digital health, whereas cybersecurity includes broader strategies, technologies, and incident response.",
                        "Cyber hygiene focuses only on personal devices, while cybersecurity is limited to organizations."
                },
                3, 3, week5.title
        ));

        week5.add(new Question(
                "True or False: Configuration rules govern how a security system reacts to the data it receives.",
                new String[]{"True", "False", "", ""}, 1, 2, week5.title
        ));

        week5.add(new Question(
                "Which of the following is not true about Systems-Specific Security Policies (SysSPs)?",
                new String[]{
                        "SysSPs can be separated into two general groups, managerial guidance SysSPs and technical specifications SysSPs.",
                        "SysSPs function as standards or procedures to be used when configuring or maintaining systems.",
                        "SysSPs can be combined into a single policy document that contains elements of both managerial guidance SysSPs and technical specifications SysSPs.",
                        "SysSPs can be developed at the same time as Issue-specific policies (ISSPs), or they can be prepared after their related ISSPs."
                },
                4, 3, week5.title
        ));

        week5.add(new Question(
                "Which of the following are the basic rules that should be followed when shaping a policy?",
                new String[]{
                        "Never conflict with law",
                        "Properly supported and administered",
                        "Involve end users of information systems",
                        "All the above"
                },
                4, 3, week5.title
        ));

        week5.add(new Question(
                "The statement “Use strong passwords, frequently changed.” is an example of",
                new String[]{"Practice", "Standard", "Guideline", "Policy"}, 4, 2, week5.title
        ));
        modules.add(week5);

        TopicModule week6 = new TopicModule("Risk Management and Vulnerability Assessment");

        week6.add(new Question(
                "Risk management involves three major undertakings:",
                new String[]{
                        "Risk Auditing, Risk Assessment, and Risk Control",
                        "Risk Identification, Risk Assessment, and Risk Auditing",
                        "Risk Identification, Risk Assessment, and Risk Control",
                        "Risk Monitoring, Risk Assessment, and Risk Auditing"
                },
                3, 4, week6.title
        ));

        week6.add(new Question(
                "Determine Loss Frequency (Likelihood) comes under:",
                new String[]{"Risk Identification", "Risk Auditing", "Risk Monitoring", "Risk Assessment"},
                4, 3, week6.title
        ));

        week6.add(new Question(
                "Residual risk is a combined function of",
                new String[]{
                        "(1) a threat less the effect of threat-reducing safeguards, (2) a vulnerability less the effect of vulnerability-reducing safeguards, and (3) an asset less the effect of asset value-reducing safeguards.",
                        "(1) a threat less the effect of threat-reducing safeguards, (2) a vulnerability plus the effect of vulnerability-reducing safeguards, and (3) an asset less the effect of asset value-reducing safeguards",
                        "(1) a threat plus the effect of threat-reducing safeguards, (2) a vulnerability plus the effect of vulnerability-reducing safeguards, and (3) an asset plus the effect of asset value-reducing safeguards",
                        "(1) a threat plus the effect of threat-reducing safeguards, (2) a vulnerability plus the effect of vulnerability-reducing safeguards, and (3) an asset less the effect of asset value-reducing safeguards"
                },
                1, 5, week6.title
        ));

        week6.add(new Question(
                "Risk tolerance defines the quantity and nature of risk that organizations are willing to accept as they evaluate the trade-offs between perfect security and unlimited accessibility.",
                new String[]{"True", "False", "", ""}, 1, 3, week6.title
        ));

        week6.add(new Question(
                "The calculation of the likelihood of an attack coupled with the attack frequency to determine the expected number of losses within a specified time range is called",
                new String[]{"Attack Success Probability", "Loss Frequency", "Loss Magnitude", "Probable Loss"},
                2, 3, week6.title
        ));

        week6.add(new Question(
                "TechNova Inc. owns Asset A, an online customer transactions database. Industry research suggests there is a 10% probability of a cyberattack against this database in the coming year, based on an estimated frequency of one attack every 10 years. The company’s information security and IT teams estimate that, if such an attack occurs, there is a 50% chance it will be successful given current vulnerabilities and existing security measures. The database has an asset value of 50 on a 0–100 scale, and the teams believe that a successful attack would result in 100% loss or compromise of the asset. Based on current knowledge, the security team believes that these assumptions and data are 90% accurate.\n\nUsing the formula: Risk =(Loss Frequency × Loss Magnitude)+ Uncertainty Term Calculate the final risk score for Asset A.",
                new String[]{"2.75", "2.5", "3.75", "2.25"},
                1, 5, week6.title
        ));

        week6.add(new Question(
                "Which of the following is not true?",
                new String[]{
                        "The mitigation risk control strategy attempts to shift risk to other assets, other processes, or other organizations.",
                        "The mitigation risk control strategy reduces the impact of the loss caused by a realized incident, disaster, or attack through effective contingency planning and preparation.",
                        "The mitigation risk control strategy attempts to reduce the impact of an attack rather than reduce the success of the attack itself.",
                        "The mitigation risk control strategy requires the creation of three types of contingency plans: the incident response plan, the disaster recovery plan, and the business continuity plan."
                },
                1, 4, week6.title
        ));

        week6.add(new Question(
                "The process of identifying and documenting specific and provable flaws in the organization’s information asset environment is known as:",
                new String[]{"Risk Assessment", "Vulnerability Assessment", "Asset Scanning", "Risk Control"},
                2, 3, week6.title
        ));

        week6.add(new Question(
                "“Blackmail threat of information disclosure” is an example of:",
                new String[]{"Espionage or trespass", "Compromises to intellectual property", "Information extortion", "Sabotage or vandalism"},
                3, 3, week6.title
        ));

        week6.add(new Question(
                "Which of the following statements is not true?",
                new String[]{
                        "Risk management examines and documents the information technology security being used in an organization.",
                        "A key component of a risk management strategy is the identification and classification of the organization’s information assets, while prioritization is performed only after risk controls are implemented.",
                        "Risk management helps an organization identify vulnerabilities in its information systems and take carefully reasoned steps to assure the confidentiality, integrity, and availability of all components in those systems.",
                        "The goal of risk assessment is to assign a risk rating or score that represents the relative risk for a specific vulnerability of an information asset."
                },
                2, 5, week6.title
        ));
        modules.add(week6);

        return modules;
    }
}