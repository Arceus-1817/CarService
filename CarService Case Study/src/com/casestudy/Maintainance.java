package com.casestudy;
	import java.util.LinkedList;
	public class Maintainance extends Services {
	
		private static final long serialVersionUID = 1L;
		private double laborCharges;
		private LinkedList<Parts> partList;
		public Maintainance() {
			this.laborCharges=0.0;
			
		}
		public Maintainance(String desc, double laborCharges) {
			super(desc);
			this.laborCharges = laborCharges;
			this.partList = new LinkedList<>();
		}
		public double getLaborCharges() {
			return laborCharges;
		}
		public void setLaborCharges(double laborCharges) {
			this.laborCharges = laborCharges;
		}
		public LinkedList<Parts> getPartList() {
			return partList;
		}
		public void setPartList(LinkedList<Parts> partList) {
			this.partList = partList;
		}
		public void newSparePart(Parts part) {
			this.partList.add(part);
		}
		@Override
		public double price() {
			double total = this.laborCharges;
			for (Parts part : partList) {
				total += part.getPrice();
			}
			return total;
		}

		@Override
		public String toString() {
			return "[M] " + super.toString();
		}
	}
