# 🌐 Enterprise CCNA Networking & Packet Tracer Design

Welcome to my computer networking repository! This project presents a full enterprise network architecture designed, configured, and validated using **Cisco Packet Tracer**.

---

## 📌 Project Overview
The primary objective of this project is to build a secure, scalable, and fully functional multi-site enterprise network (such as a healthcare or corporate infrastructure) with dynamic routing, VLAN segmentation, automated IP allocation, and traffic control.

* **Main Simulation File:** `finaly.pkt` (Cisco Packet Tracer Lab File)
* **Project Status:** Completed, Fully Configured & Verified

---

## 🛠️ Key Network Technologies & Services

### 1. Dynamic Routing & Core Routing (OSPF)
* **OSPF (Open Shortest Path First):** Configured across core and edge routers (`R-core`, `R_LB`, `R_EM`) to enable dynamic route discovery and redundant path selection.
* **Static Routing:** Applied on serial point-to-point links for predictable inter-site traffic management.

### 2. VLAN Segmentation & Inter-VLAN Routing
* **VLAN Deployment:** Configured on access switches to isolate department traffic, reduce broadcast domains, and enhance network security.
* **Trunking & ROAS:** Implemented 802.1Q trunking and **Router-on-a-Stick (ROAS)** for seamless communication between distinct VLANs.

### 3. Automated IP Management (DHCP Server)
* **DHCP Pools:** Configured routers (`R_EM` and `R_LB`) as dedicated DHCP servers to dynamically allocate IP addresses, subnet masks, default gateways, and DNS settings to end devices (`PC0`, `PC1`, `PC2`, etc.).
* **Binding Verification:** Monitored active leases using the `show ip dhcp binding` command to verify client MAC-to-IP mappings.

### 4. Network Security & Traffic Filtering (ACLs)
* **Access Control Lists (Extended ACL 105):** Applied extended ACL rules to restrict unauthorized subnet communication, filter sensitive protocols, and enforce security policies across network segments.

### 5. Local Web Services & DNS
* **Web Server Access:** Hosted and verified a local intranet web server (`www.medicare.local`), confirming functional HTTP and DNS resolution from client machines.

---

## 🖼️ Lab Documentation & Verification

| File Name | Description & Applied Technology |
| :---: | :--- |
| **`network1.jpeg`** | Full logical network topology overview. |
| **`network2.jpeg` / `network3.jpeg`** | Router interface IP configurations and VLAN trunking setups. |
| **`network4.jpeg` / `network5.jpeg`** | OSPF routing table verification (`show ip route`) and active path discovery. |
| **`network6.jpeg` / `network7.jpeg`** | Active DHCP bindings check and Extended ACL 105 security rule deployment. |
| **`network8.jpeg` / `network9.jpeg`** | End-to-end ICMP `ping` testing, path validation, and ACL block checks. |
| **
