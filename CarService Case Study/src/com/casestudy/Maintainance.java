package com.casestudy;
	import java.util.LinkedList;
	public class Maintainance extends Services {
	
		private static final long serialVersionUID = 1L;
		private double laborCharges;
		private String workDes;
		
//		public Maintainance() {
//			this.laborCharges=0.0;
//			
//		}
		public Maintainance(String Des, double laborCharges) {
			super(Des, Des);
			this.laborCharges = laborCharges;
			this.workDes =Des ;
		}
		public double getLaborCharges() {
			return laborCharges;
		}
		public void setLaborCharges(double laborCharges) {
			this.laborCharges = laborCharges;
		}
		
		
		
//		public LinkedList<Parts> getPartList() {
//			return partList;
//		}
//		public void setPartList(LinkedList<Parts> partList) {
//			this.partList = partList;
//		}
//		public void newSparePart(Parts part) {
//			this.partList.add(part);
//		}
		
		
		public String getWorkDes() {
			return workDes;
		}
		public void setWorkDes(String workDes) {
			this.workDes = workDes;
		}
//		public double price() {
//			double total = this.laborCharges;
//			for (Parts part : partList) {
//				total += part.getPrice();
//			}
//			return total;
//		}

		
		
		public double price(double laborCharges) {
			return this.laborCharges;
		}
		@Override
		public String toString() {
			return super.toString();
		}
		
	}
